package com.codeninjas.inventoryservice.service;


import com.codeninjas.inventoryservice.Exception.InventoryServiceException;
import com.codeninjas.inventoryservice.domain.Inventory;

import java.util.List;

public interface InventoryService{
    Inventory addInventory (Inventory inventory);

    List<Inventory> getAllInventory ();

    Inventory updateInventory (String id ,Inventory inventory) throws InventoryServiceException;

    void deleteInventory (String id) throws InventoryServiceException;

    Inventory getInventoryById (String id) throws InventoryServiceException;

}
