package com.laarizag.Inventory.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "productId")
    private Long id;
    private String cod;
    private String name;
    private double price;
    private int stock;

    @ManyToMany(mappedBy = "productsInStore")
    @JsonIgnoreProperties(value = {"products_in_store", "hibernateLazyInitializer", "handler"})
    private Set<Store> availableStores;

    @OneToMany(mappedBy = "product")
    private Set<OrderDetail> orderDetails;

}
