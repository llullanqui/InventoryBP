package com.laarizag.Inventory.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orderDetailId")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "FK_Store_OrderDetail", nullable = false, updatable = false)
    @JsonIgnoreProperties({"products_in_store", "order_details"})
    private Store store;

    @ManyToOne
    @JoinColumn(name = "FK_Product_Detail", nullable = false, updatable = false)
    @JsonIgnoreProperties({"order_details", "available_stores", "price", "stock"})
    private Product product;

    @Column(nullable = false, updatable = false)
    private int quantity;

    @Column(nullable = false, updatable = false)
    private double price;

    @ManyToOne
    @JoinColumn(name = "FK_Order_OrderDetail")
    @JsonIgnoreProperties(value = {"order_detail_set", "hibernateLazyInitializer", "handler"})
    private Order order;

}
