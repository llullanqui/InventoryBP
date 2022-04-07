package com.laarizag.Inventory.repository;

import com.laarizag.Inventory.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
