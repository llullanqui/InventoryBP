package com.laarizag.Inventory.repository;

import com.laarizag.Inventory.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
