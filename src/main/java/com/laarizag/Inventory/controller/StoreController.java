package com.laarizag.Inventory.controller;

import com.laarizag.Inventory.dto.AddProductToStoreRequest;
import com.laarizag.Inventory.model.Store;
import com.laarizag.Inventory.service.ProductService;
import com.laarizag.Inventory.service.StoreService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @Autowired
    private ProductService productService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Store> getStores() {
        return storeService.getAllStores();
    }

    @PostMapping("/{id}/addProduct")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void assignProductToStore(@PathVariable Long id, @RequestBody AddProductToStoreRequest request) {
        storeService.addProductToStore(id, productService.getProductById(request.getProductId()));
    }

}
