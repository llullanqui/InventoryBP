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
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orderId")
    private Long id;

    @MapsId
    @OneToOne
    private Client client;

    @OneToMany(mappedBy = "order")
    private Set<OrderDetail> orderDetailSet;

}
