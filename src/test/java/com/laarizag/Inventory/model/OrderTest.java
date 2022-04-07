package com.laarizag.Inventory.model;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
class OrderTest {

    @Test
    void shouldReturnTotalPrice() {
        var Order = com.laarizag.Inventory.model.Order.builder()
                .orderDetailSet(Set.of(OrderDetail.builder()
                                .price(10)
                                .quantity(2)
                        .build()))
                .build();

        assertThat(Order.calculateTotalPrice(), Matchers.equalTo(20.0));
    }

}
