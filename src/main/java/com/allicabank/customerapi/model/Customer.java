package com.allicabank.customerapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

/**
 * Represents a customer entity in the system.
 * This class is mapped to the 'customers' table in the database.
 */
@Entity
@Table(name = "customers")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
}
