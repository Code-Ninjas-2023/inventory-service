package com.codeninjas.inventoryservice.service;

import com.codeninjas.inventoryservice.Exception.InventoryServiceException;
import com.codeninjas.inventoryservice.domain.Inventory;
import com.codeninjas.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    @Override
    public Inventory addInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    @Override
    public Inventory updateInventory(String id, Inventory inventory) throws InventoryServiceException {
        Inventory newInventory = inventoryRepository.findById(id).orElseThrow(() -> new InventoryServiceException("Inventory not found"));
        newInventory.setInventoryId(id);
        newInventory.setQuality(inventory.getQuality());
        newInventory.setItemCode(inventory.getItemCode());
        inventoryRepository.save(newInventory);
        return newInventory;
    }

    @Override
    public void deleteInventory(String id) throws InventoryServiceException {
        inventoryRepository.findById(id).orElseThrow(() -> new InventoryServiceException("Inventory not found"));
        inventoryRepository.deleteById(id);

    }

    @Override
    public Inventory getInventoryById(String id) throws InventoryServiceException {
        return inventoryRepository.findById(id).orElseThrow(() -> new InventoryServiceException("Inventory not Found"));
    }
}
