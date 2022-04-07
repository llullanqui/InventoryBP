package com.laarizag.Inventory.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "storeId")
    private Long id;
    private String code;
    private String name;

    @ManyToMany
    @JoinTable(
            name = "storeProduct",
            joinColumns = @JoinColumn(name = "storeId"),
            inverseJoinColumns = @JoinColumn(name = "productId")
    )
    private Set<Product> productsInStore;

}
