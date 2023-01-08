package com.demoinventoryservice.demoinventoryservice.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demoinventoryservice.demoinventoryservice.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public boolean isInStock(String skuCode) {

        return inventoryRepository.findBySkuCode(skuCode).isPresent();

    }

}
