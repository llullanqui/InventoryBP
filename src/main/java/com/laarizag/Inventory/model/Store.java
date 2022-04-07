package com.laarizag.Inventory.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Store implements Serializable {

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
    @JsonIgnoreProperties({"available_stores","hibernateLazyInitializer", "handler"})
    private Set<Product> productsInStore = new HashSet<>();

    // Por cada tienda se debe guardar el registro de las transacciones realizadas, donde se indique: cliente, producto, cantidad, fecha y hora. (aplique la solución mas genérica posible).
    @OneToMany(mappedBy = "store")
    private Set<OrderDetail> orderDetails;

}
