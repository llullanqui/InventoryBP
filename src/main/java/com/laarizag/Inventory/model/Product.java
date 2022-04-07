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
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "productId")
    private Long id;
    private String cod;
    private String name;
    private double price;
    private int stock;

    @ManyToMany(mappedBy = "productsInStore")
    private Set<Store> availableStores;

}
