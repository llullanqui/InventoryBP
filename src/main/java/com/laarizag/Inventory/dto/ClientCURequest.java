package com.laarizag.Inventory.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ClientCURequest {

    @NotNull
    private String name;
    @NotNull
    private String identification;
    private byte[] picture;
}
