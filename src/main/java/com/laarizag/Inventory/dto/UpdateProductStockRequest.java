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
    @Min(1)
    private int stock;

}
