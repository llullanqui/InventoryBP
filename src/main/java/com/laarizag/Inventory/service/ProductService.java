package com.laarizag.Inventory.service;

import com.laarizag.Inventory.dto.UpdateProductStockRequest;
import com.laarizag.Inventory.model.Product;
import com.laarizag.Inventory.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.getById(id);
    }

    public Product updateProductStock(Long id, UpdateProductStockRequest request) {
        var product = productRepository.getById(id);
        product.setStock(request.getStock());
        productRepository.save(product);
        return product;
    }

    public Product addStock(Long id, int quantity) {
        var product = productRepository.getById(id);
        product.setStock(product.getStock() + quantity);
        productRepository.save(product);
        return product;
    }

    public Product removeStock(Long id, int quantity) {
        var product = productRepository.getById(id);
        product.setStock(product.getStock() - quantity);
        productRepository.save(product);
        return product;
    }

}
