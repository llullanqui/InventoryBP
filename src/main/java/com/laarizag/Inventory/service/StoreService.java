package com.laarizag.Inventory.service;

import com.laarizag.Inventory.dto.UpdateProductStockRequest;
import com.laarizag.Inventory.dto.model.StoreDto;
import com.laarizag.Inventory.exception.StoreNotFoundException;
import com.laarizag.Inventory.mapper.MapStructMapper;
import com.laarizag.Inventory.model.Product;
import com.laarizag.Inventory.model.Store;
import com.laarizag.Inventory.repository.ProductRepository;
import com.laarizag.Inventory.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    public Store getStoreById(Long id) {
        return storeRepository.getById(id);
    }

    public void addProductToStore(Long storeId, Product product) {
        var store = storeRepository.getById(storeId);
        store.getProductsInStore().add(product);
        storeRepository.save(store);
    }
}
