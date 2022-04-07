package com.laarizag.Inventory.controller;

import com.laarizag.Inventory.dto.GenerateOrderRequest;
import com.laarizag.Inventory.exception.ProductOutOfStockException;
import com.laarizag.Inventory.model.Order;
import com.laarizag.Inventory.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    Order generateOrder(@RequestBody Order newOrder) {
        return orderService.generateOrder(newOrder);
    }

}
