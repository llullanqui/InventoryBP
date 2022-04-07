package com.laarizag.Inventory.dto;

import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GenerateOrderRequest {

    private List<GenerateOrderRequestDetail> details;

}
