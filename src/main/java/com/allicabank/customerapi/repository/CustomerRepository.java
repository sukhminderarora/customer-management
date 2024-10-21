package com.allicabank.customerapi.repository;

import com.allicabank.customerapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

/**
 * Repository interface for accessing and managing {@link Customer} entities.
 * This interface extends JpaRepository, providing CRUD operations and custom queries.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    /**
     * Finds a customer by their first name, last name, and date of birth.
     *
     * @param firstName the first name of the customer.
     * @param lastName the last name of the customer.
     * @param dateOfBirth the date of birth of the customer.
     * @return an Optional containing the found customer, or an empty Optional if no customer is found.
     */
    Optional<Customer> findByFirstNameAndLastNameAndDateOfBirth(String firstName, String lastName, LocalDate dateOfBirth);
}
