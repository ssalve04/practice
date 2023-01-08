package com.fullbuild.inventoryservice.controller;


import com.fullbuild.inventoryservice.dto.InventoryResponse;
import com.fullbuild.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    // @Pathvariable uri : http://localhost:8082/api/inventory/iphone-14,iphone14-red
    // @RequestParam uri : http://localhost:8082/api/inventory?skuCode=iphone-14&skuCode=iphone14-red
    // RequestParam uri is more readable
    @GetMapping("/{sku-code}")
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode){

        return inventoryService.isInStock(skuCode);
    }
}
