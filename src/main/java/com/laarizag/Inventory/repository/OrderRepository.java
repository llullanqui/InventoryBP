package com.laarizag.Inventory.repository;

import com.laarizag.Inventory.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
