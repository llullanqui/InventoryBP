package com.laarizag.Inventory.model;

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

    @MapsId
    @ManyToOne
    @JoinColumn(name = "FK_Store", nullable = false, updatable = false)
    private Store store;

    @MapsId
    @ManyToOne
    @JoinColumn(name = "FK_Product", nullable = false, updatable = false)
    private Product product;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "FK_ORDER_ID")
    private Order order;

}
