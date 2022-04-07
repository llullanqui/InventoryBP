package com.laarizag.Inventory.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jdk.jfr.SettingDefinition;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "order_table")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orderId")
    private Long id;

    @ManyToOne
    @JoinColumn(name="FK_CLIENT_ORDER", nullable = false, updatable = false)
    @JsonIgnoreProperties(value = {"orders", "hibernateLazyInitializer", "handler"})
    private Client client;

    @OneToMany(mappedBy = "order")
    @JsonIgnoreProperties(value = {"order", "products_in_store", "hibernateLazyInitializer", "handler"})
    private Set<OrderDetail> orderDetailSet = new HashSet<>();

    @CreationTimestamp
    private Timestamp timestamp;

    @Column(nullable = false)
    private double totalPrice;

    public double calculateTotalPrice() {
        double currentTotal = 0;
        for(var detail : orderDetailSet) {
            currentTotal += detail.getQuantity()*detail.getPrice();
        }
        return currentTotal;
    }

}
