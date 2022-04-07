package com.laarizag.Inventory.dto;

import com.laarizag.Inventory.model.Product;
import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductWrapper {

    private List<Product> prods;

}
