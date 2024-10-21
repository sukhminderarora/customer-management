package com.allicabank.customerapi.exception;

import lombok.*;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

/**
 * A class representing an error response for API errors.
 * This class encapsulates the details of an error that occurs within the application.
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ErrorResponse {

    private HttpStatus status;
    private String message;
    private LocalDateTime timestamp;
}
