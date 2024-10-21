package com.allicabank.customerapi.controller;

import com.allicabank.customerapi.model.Customer;
import com.allicabank.customerapi.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

/**
 * REST Controller for handling customer-related API requests.
 * Provides endpoints for creating a new customer and fetching all customers.
 * <p>
 * Mapped to "/api/customers".
 */
@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    /**
     * API endpoint to create a new customer.
     * Accepts a customer object in the request body, validates it, and saves it to the database.
     *
     * @param customer the customer object sent in the request body.
     * @return a ResponseEntity containing the saved customer object and HTTP status 201 (Created).
     */
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer) {
        Customer savedCustomer = customerService.saveCustomer(customer);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    /**
     * API endpoint to retrieve a list of all customers.
     * Fetches all customer records from the database and returns them in the response.
     *
     * @return a ResponseEntity containing the list of all customers and HTTP status 200 (OK).
     */
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
}

