package com.example.spring_learning.controller;

import com.example.spring_learning.service.RetryAsyncService;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(value = "/internationalization")
public class InternationalizationController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private RetryAsyncService asyncService;

    @GetMapping
    public String helloWorldInternationalized(@RequestHeader(name="Accept-Language", required=false) Locale locale)
    {
        return messageSource.getMessage("good.morning.message", null, locale);
    }

    @GetMapping(path="/asyncService")
    public String retryAsyncService(@RequestHeader(name="Accept-Language", required=false) Locale locale)
      throws ExecutionException, InterruptedException {
        return asyncService.processWithRetry();
    }

    @RateLimiter(name = "myRateLimiter", fallbackMethod = "fallbackForRateLimiter")
    @GetMapping(path="/greet")
    public ResponseEntity<String> helloWorldInternationalize(@RequestParam(value = "lang", required=false) String lang)
    {
        Locale locale = (lang != null) ? new Locale(lang) : Locale.getDefault();
        return new ResponseEntity<>(messageSource.getMessage("good.morning.message", null, locale),
            HttpStatus.OK);
    }

    private ResponseEntity<String> fallbackForRateLimiter(Throwable t) {
        return new ResponseEntity<>("Too many requests! \n Please try again after some time.",
            HttpStatus.TOO_MANY_REQUESTS);

    }
}
