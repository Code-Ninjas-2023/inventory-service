package com.codeninjas.inventoryservice.controller;

import com.codeninjas.inventoryservice.Exception.InventoryServiceException;
import com.codeninjas.inventoryservice.domain.Inventory;
import com.codeninjas.inventoryservice.service.InventoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/inventories")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;
    @GetMapping
    public ResponseEntity<List<Inventory>> getAllInventories() {
        List<Inventory> response = inventoryService.getAllInventory();
        if (response.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Inventory> createInventory(@Valid @RequestBody Inventory inventory) {
        Inventory response = inventoryService.addInventory(inventory);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Inventory> getInventoryById(@PathVariable String id) throws InventoryServiceException {
        Inventory response = inventoryService.getInventoryById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteById(@PathVariable String id) throws InventoryServiceException {
        inventoryService.deleteInventory(id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> updateById(@PathVariable String id, @Valid @RequestBody Inventory inventory) throws InventoryServiceException {
        inventoryService.updateInventory(id, inventory);
        return new ResponseEntity<String>(HttpStatus.OK);
    }


}
