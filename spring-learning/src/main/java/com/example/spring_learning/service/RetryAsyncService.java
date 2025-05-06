package com.example.spring_learning.service;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class RetryAsyncService {
    @Retryable(
            value = RuntimeException.class,
            maxAttempts = 3,
            backoff = @Backoff(delay = 2000)
    )
    public String processWithRetry() {
        System.out.println("Attempting async task...");
        if (Math.random() > 0.7) {
            return "Success!";
        }
        throw new RuntimeException("Task failed! Retrying...");
    }
}
