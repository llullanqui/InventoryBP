package com.laarizag.Inventory.dto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.laarizag.Inventory.model.OrderDetail;
import lombok.*;

import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderDto {

    @JsonProperty
    private Long id;

    @JsonProperty
    private ClientDto client;

    @JsonProperty("order_details")
    @JsonIgnoreProperties({"order"})
    private Set<OrderDetailDto> orderDetailSet;
}
