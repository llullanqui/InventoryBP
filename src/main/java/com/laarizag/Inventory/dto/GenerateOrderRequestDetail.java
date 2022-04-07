package com.laarizag.Inventory.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class GenerateOrderRequestDetail {

    @JsonProperty
    private Long store;

    @JsonProperty
    private Long product;

    @JsonProperty
    private int quantity;

}
