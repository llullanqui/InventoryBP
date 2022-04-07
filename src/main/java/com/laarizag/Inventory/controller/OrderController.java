package com.laarizag.Inventory.controller;

import com.laarizag.Inventory.dto.GenerateOrderRequest;
import com.laarizag.Inventory.exception.ProductOutOfStockException;
import com.laarizag.Inventory.mapper.MapStructMapper;
import com.laarizag.Inventory.model.Order;
import com.laarizag.Inventory.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    private final MapStructMapper mapper;

    @GetMapping
    public List<Order> orderList() {
        return orderService.getAllOrders();
    }

    @PostMapping
    public void generateOrder(@RequestBody GenerateOrderRequest request) throws ProductOutOfStockException {
        orderService.generateOrder(request);
    }

}
