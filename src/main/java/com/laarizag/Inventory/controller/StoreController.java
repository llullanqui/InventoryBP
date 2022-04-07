package com.laarizag.Inventory.controller;

import com.laarizag.Inventory.model.Store;
import com.laarizag.Inventory.service.StoreService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private StoreService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Store> getStores() {
        return service.getAllStores();
    }

}
