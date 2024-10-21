package com.allicabank.customerapi.handler;

import com.allicabank.customerapi.exception.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;


/**
 * Global exception handler for the application.
 * This class is responsible for handling exceptions thrown within the application and
 * providing appropriate error responses to the clients.
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * Handles all exceptions
     * Logs the error and returns a standardized error response.
     *
     * @param ex the exception that was thrown
     * @return a ResponseEntity containing the error response with a status of 500 Internal Server Error
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGeneralException(Exception ex) {
        log.error("Exception occurred: ", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorResponse.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR).message(ex.getMessage()).timestamp(LocalDateTime.now()).build());
    }

}

