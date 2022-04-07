package com.laarizag.Inventory.dto;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpdateProductStockRequest {

    private Long id;

    @NotNull
    @Min(value = 1, message = "Stock no puede ser 0 o menor.")
    private int stock;

}
