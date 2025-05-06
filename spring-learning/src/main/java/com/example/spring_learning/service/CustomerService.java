package com.example.spring_learning.service;

import com.example.spring_learning.config.NotFoundException;
import com.example.spring_learning.model.Customer;
import com.example.spring_learning.repository.CustomerRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final RestTemplate restTemplate = new RestTemplate();
    @Autowired
    private CustomerRepository customerRepository;

    private final ObjectMapper mapper = new ObjectMapper();
    public List<Customer> allCustomers() throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> results = restTemplate
            .exchange("https://customer-service.free.beeceptor.com/customer-service/v3/customers/inquiry",
            HttpMethod.GET, entity, String.class);
        List<?> temp = mapper.readValue(results.getBody(), List.class);
        List<Customer> responses = new ArrayList<>();
        for (Object obj : temp) {
            responses.add(mapper.convertValue(obj, Customer.class));
        }
        responses.forEach(c -> customerRepository.save(c));
        return responses;
    }

    public Optional<Customer> getCustomerByName(String name) {
        return Optional.of(customerRepository.findByCustomerName(name).orElseThrow(() -> new
            NotFoundException("Customer with name " + name + " is not found.")));
    }
}
