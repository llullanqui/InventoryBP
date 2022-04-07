package com.laarizag.Inventory.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GenerateOrderRequest {

    @JsonProperty
    private Long client;

    @JsonProperty
    private List<GenerateOrderRequestDetail> details;

}
