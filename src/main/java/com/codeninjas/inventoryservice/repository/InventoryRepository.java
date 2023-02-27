package com.codeninjas.inventoryservice.repository;

import com.codeninjas.inventoryservice.domain.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends MongoRepository<Inventory, String> {
}
