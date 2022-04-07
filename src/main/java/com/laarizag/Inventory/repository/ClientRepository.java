package com.laarizag.Inventory.repository;

import com.laarizag.Inventory.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
