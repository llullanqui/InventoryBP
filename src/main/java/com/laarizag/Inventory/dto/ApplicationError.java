package com.laarizag.Inventory.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@Builder
@RequiredArgsConstructor
public class ApplicationError {
    private final HttpStatus httpStatus;
    private final String message;
}
