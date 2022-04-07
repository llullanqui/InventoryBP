package com.laarizag.Inventory.dto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.laarizag.Inventory.model.Store;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDto {

    @JsonProperty
    private Long id;

    @JsonProperty
    private String cod;

    @JsonProperty
    private String name;

    @JsonProperty
    private double price;

    @JsonProperty
    private int stock;

    @JsonProperty
    @JsonIgnoreProperties(value = {"products_in_store"})
    private Set<Store> availableStores;
}
