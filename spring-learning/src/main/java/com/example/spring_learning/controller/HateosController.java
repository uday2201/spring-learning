package com.example.spring_learning.controller;

import com.example.spring_learning.model.Customer;
import com.example.spring_learning.model.Order;
import com.example.spring_learning.service.CustomerService;
import com.example.spring_learning.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping({"/hateos", "admin/hateos"})
public class HateosController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/customers", produces = { "application/hal+json" })
    public CollectionModel<Customer> getAllCustomers() throws JsonProcessingException {
        List<Customer> allCustomers = customerService.allCustomers();

        for (Customer customer : allCustomers) {
            String customerId = customer.getCustomerId();
            Link selfLink = linkTo(HateosController.class).slash(customerId).withSelfRel();
            customer.add(selfLink);
            if (!orderService.getAllOrdersForCustomer(customerId).isEmpty()) {
                Link ordersLink = linkTo(methodOn(HateosController.class)
                        .getOrdersForCustomer(customerId)).withRel("allOrders");
                customer.add(ordersLink);
            }
        }

        Link link = linkTo(HateosController.class).withSelfRel();
        return CollectionModel.of(allCustomers, link);
    }

    @GetMapping(value = "/{customerId}/orders", produces = { "application/hal+json" })
    public CollectionModel<Order> getOrdersForCustomer(@PathVariable String customerId) {
        List<Order> orders = orderService.getAllOrdersForCustomer(customerId);
        for (final Order order : orders) {
            Link selfLink = linkTo(methodOn(HateosController.class)
                .getOrderById(customerId, order.getOrderId())).withSelfRel();
            order.add(selfLink);
        }

        Link link = linkTo(methodOn(HateosController.class)
            .getOrdersForCustomer(customerId)).withSelfRel();
        return CollectionModel.of(orders, link);

    }

    @GetMapping(value = "/{customerName}", produces = { "application/json" })
    public ResponseEntity<Customer> getCustomerByName(@PathVariable String customerName) {
        Optional<Customer> customerOptional = customerService.getCustomerByName(customerName);
        return ResponseEntity.ok(customerOptional.orElse(null));
    }

    @GetMapping(value = "/{customerId}/orders/{orderId}", produces = { "application/hal+json" })
    public CollectionModel<Order> getOrderById(@PathVariable String customerId, @PathVariable String orderId) {
        List<Order> orders = orderService.getOrderById(orderId);

        Link link = linkTo(methodOn(HateosController.class)
                .getOrdersForCustomer(customerId)).withSelfRel();
        return CollectionModel.of(orders, link);

    }


}
