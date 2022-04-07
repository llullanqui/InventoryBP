package com.laarizag.Inventory.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class GenerateOrderRequestDetail {

    private Long store;
    private Long product;
    private int quantity;

}
