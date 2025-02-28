package com.allicabank.customerapi.service;

import com.allicabank.customerapi.model.Customer;
import com.allicabank.customerapi.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing customers. Provides methods for creating,
 * retrieving, and checking the existence of customer records.
 */
@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    /**
     * Saves a customer entity to the database.
     *
     * @param customer the customer entity to be saved.
     * @return the saved customer entity.
     */
    public Customer saveCustomer(Customer customer) {
        if(customer.getFirstName().isEmpty() || customer.getLastName().isEmpty()){
            throw new RuntimeException("First Name should be present");
        }
        if(customerExists(customer)){
            throw new RuntimeException("This Customer already exists");
        }
        return customerRepository.save(customer);
    }

    /**
     * Retrieves all customer entities from the database.
     *
     * @return a list of all customers.
     */
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    /**
     * Checks if a customer already exists in the database based on their first name, last name, and date of birth.
     *
     * @param customer the customer entity to be checked.
     * @return true if the customer exists, false otherwise.
     */
    public boolean customerExists(Customer customer) {
        return customerRepository.findByFirstNameAndLastNameAndDateOfBirth(
                customer.getFirstName(),
                customer.getLastName(),
                customer.getDateOfBirth()
        ).isPresent();
    }
}
