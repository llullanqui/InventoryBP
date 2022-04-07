package com.laarizag.Inventory.dto.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

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

}
