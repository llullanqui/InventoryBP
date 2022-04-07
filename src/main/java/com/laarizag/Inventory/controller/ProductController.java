package com.laarizag.Inventory.controller;

import com.laarizag.Inventory.dto.UpdateProductStockRequest;
import com.laarizag.Inventory.model.Product;
import com.laarizag.Inventory.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private final ProductService productService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product getProduct(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PutMapping(value = "/{id}/stock")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateProductStock(@PathVariable Long id, @Valid @RequestBody UpdateProductStockRequest updateProductStockRequest) {
        productService.updateProductStock(id, updateProductStockRequest);
    }
}
