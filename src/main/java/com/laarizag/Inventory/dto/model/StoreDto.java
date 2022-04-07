package com.laarizag.Inventory.dto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.laarizag.Inventory.model.Product;
import lombok.*;

import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StoreDto {

    @JsonProperty
    private Long id;

    @JsonProperty
    private String code;

    @JsonProperty
    private String name;

    @JsonProperty
    @JsonIgnoreProperties({"available_stores"})
    private Set<Product> productsInStore;

}
