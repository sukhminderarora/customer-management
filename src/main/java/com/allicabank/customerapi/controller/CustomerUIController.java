package com.allicabank.customerapi.controller;

import com.allicabank.customerapi.model.Customer;
import com.allicabank.customerapi.service.CustomerService;
import com.allicabank.customerapi.utility.CustomerValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CustomerUIController {

    private final CustomerService customerService;
    private final CustomerValidator customerValidator;

    /**
     * Displays the customer form for creating a new customer.
     * Initializes an empty customer object to bind with the form.
     *
     * @param model the model to hold data that will be rendered on the view.
     * @return the name of the view that displays the customer form.
     */
    @GetMapping("/customers")
    public String showCustomerForm(Model model) {
        model.addAttribute("customer", Customer.builder().build());
        return "customer_form";
    }

    /**
     * Handles the form submission for adding a new customer.
     * Validates the form fields and handles error messages for empty fields.
     * If validation passes, checks for duplicate customers and saves the customer if not found.
     *
     * @param customer the customer object bound from the form submission.
     * @param model    the model to hold form data and error/success messages.
     * @return the name of the view to display, either showing errors or a success message.
     */
    @PostMapping("/customers")
    public String addCustomer(@ModelAttribute Customer customer, Model model) {
        customerValidator.validateCustomerInput(customer, model);

        if (customer.getDateOfBirth() != null && customer.getDateOfBirth().isAfter(LocalDate.now())) {
            model.addAttribute("dobError", "Date of Birth cannot be in the future. It must be today or earlier.");
        }

        if (model.containsAttribute("firstNameError") || model.containsAttribute("lastNameError") || model.containsAttribute("dobError")) {
            model.addAttribute("customer", customer);
            return "customer_form";
        }

        if (customerService.customerExists(customer)) {
            model.addAttribute("errorMessage", "This customer already exists.");
            model.addAttribute("customer", customer);
            return "customer_form";
        }

        customerService.saveCustomer(customer);
        model.addAttribute("successMessage", "Customer data is saved.");
        model.addAttribute("customer", Customer.builder().build());
        return "customer_form";
    }

    /**
     * Displays a list of all customers.
     * Retrieves the list from the service layer and adds it to the model for rendering in the view.
     *
     * @param model the model to hold the list of customers.
     * @return the name of the view that displays the customer list.
     */
    @GetMapping("/customers/list")
    public String listCustomers(Model model) {
        List<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("customers", customers);
        return "customer_list";
    }
}
