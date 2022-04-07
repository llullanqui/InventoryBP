package com.laarizag.Inventory.dto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClientDto {

    @JsonProperty
    private int id;

    @JsonProperty
    private String name;

    @JsonProperty
    private String identification;

    @JsonProperty
    private byte[] picture;

    @JsonProperty
    @JsonIgnoreProperties(value = {"client"})
    private Set<OrderDto> orders;

}
