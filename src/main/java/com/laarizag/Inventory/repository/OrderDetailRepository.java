package com.laarizag.Inventory.repository;

import com.laarizag.Inventory.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
