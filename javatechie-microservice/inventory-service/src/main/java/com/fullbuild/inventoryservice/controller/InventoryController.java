package com.fullbuild.inventoryservice.controller;


import com.fullbuild.inventoryservice.dto.InventoryResponse;
import com.fullbuild.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventory")
@RequiredArgsConstructor
public class InventoryController {

    @Autowired
    private final InventoryService inventoryService;

    // http://localhost:8082/api/inventory/iphone-13,iphone13-red
    // http://localhost:8082/api/inventory?skuCode=iphone-13&skuCode=iphone13-red

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode){

        return inventoryService.isInStock(skuCode);
    }

}
