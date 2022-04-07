package com.laarizag.Inventory.handler;

import com.laarizag.Inventory.dto.ApplicationError;
import com.laarizag.Inventory.exception.ProductOutOfStockException;
import com.laarizag.Inventory.exception.StoreNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ProductOutOfStockException.class})
    public ResponseEntity<ApplicationError> handleException(ProductOutOfStockException e) {
        var error = ApplicationError.builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .message("Unidades no disponibles (> 10)")
                .build();
        return new ResponseEntity<>(error, error.getHttpStatus());
    }

    @ExceptionHandler(value = {StoreNotFoundException.class})
    public ResponseEntity<ApplicationError> handleException(StoreNotFoundException e) {
        var error = ApplicationError.builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .message("Store not found")
                .build();
        return new ResponseEntity<>(error, error.getHttpStatus());
    }
}
