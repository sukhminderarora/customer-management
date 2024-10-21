package com.allicabank.customerapi.utility;

import com.allicabank.customerapi.model.Customer;
import com.allicabank.customerapi.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

/**
 * Utility class for customer input validation.
 */
@Component
public class CustomerValidator {

    /**
     * Validates the customer input fields and adds error messages to the model.
     *
     * @param customer the customer object being validated.
     * @param model    the model to hold error messages for validation failures.
     */
    public void validateCustomerInput(Customer customer, Model model) {
        if (customer.getFirstName() == null || customer.getFirstName().isEmpty()) {
            model.addAttribute("firstNameError", "Please enter First Name");
        }
        if (customer.getLastName() == null || customer.getLastName().isEmpty()) {
            model.addAttribute("lastNameError", "Please enter Last Name");
        }
        if (customer.getDateOfBirth() == null) {
            model.addAttribute("dobError", "Please enter DOB");
        }
    }
}

