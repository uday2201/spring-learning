package com.example.spring_learning.service;

import com.example.spring_learning.model.Customer;
import com.example.spring_learning.model.Order;
import com.example.spring_learning.model.User;
import com.example.spring_learning.repository.CustomerRepository;
import com.example.spring_learning.repository.UserRepository;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;
    private final PasswordEncoder encoder;

    public DataLoader(UserRepository userRepository, PasswordEncoder encoder, CustomerRepository customerRepository) {
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
        this.encoder = encoder;
    }

    @Override
    public void run(String... args) {
        userRepository.save(User.builder().name("Uday").email("uday@example.com").password(encoder.encode("password"))
            .build());
        userRepository.save(User.builder().name("Neha").email("john@example.com").password(encoder.encode("password123"))
            .build());

        Customer newCustomer = new Customer();
        newCustomer.setCustomerName("Neha");
        newCustomer.setOrders(new ArrayList<>());
        newCustomer.setCustomerId(UUID.randomUUID().toString());
        newCustomer.setCompanyName(RandomStringUtils.random(10));
        newCustomer.addOrder(Order.builder().orderDesc("MAC Book").orderPrice("$300K").orderId(UUID
            .randomUUID().toString()).build());

        customerRepository.save(newCustomer);
    }
}
