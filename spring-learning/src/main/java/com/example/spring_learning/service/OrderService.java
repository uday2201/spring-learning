package com.example.spring_learning.service;

import com.example.spring_learning.model.Order;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class OrderService {

    public List<Order> getAllOrdersForCustomer(String customerId) {
        return Collections.singletonList(Order.builder().orderId("12").orderDesc("Apple Watch").orderPrice("$1200")
            .toAddress("Hyderabad").build());
    }

    public List<Order> getOrderById(String orderId) {
        return Collections.singletonList(Order.builder().orderId("13").orderDesc("Noise Watch").orderPrice("$1200")
                .toAddress("Hyderabad").build());
    }
}
