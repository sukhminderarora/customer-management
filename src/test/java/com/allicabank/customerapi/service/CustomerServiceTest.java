package com.allicabank.customerapi.service;

import com.allicabank.customerapi.model.Customer;
import com.allicabank.customerapi.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    public CustomerServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllCustomers() {
        when(customerRepository.findAll()).thenReturn(Collections.singletonList(Customer.builder().build()));
        List<Customer> customers = customerService.getAllCustomers();
        assertEquals(1, customers.size());
    }

}

