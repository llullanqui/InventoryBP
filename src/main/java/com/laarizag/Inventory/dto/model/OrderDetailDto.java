package com.laarizag.Inventory.dto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.laarizag.Inventory.model.Order;
import com.laarizag.Inventory.model.Product;
import com.laarizag.Inventory.model.Store;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderDetailDto {

    @JsonProperty
    private Long id;

    @JsonProperty
    private StoreDto store;

    @JsonProperty
    private ProductDto product;

    @JsonProperty
    private int quantity;

    @JsonProperty
    @JsonIgnoreProperties({"order_details"})
    private Order order;

}
