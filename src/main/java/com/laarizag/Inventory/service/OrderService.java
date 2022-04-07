package com.laarizag.Inventory.service;

import com.laarizag.Inventory.dto.RestockWrapper;
import com.laarizag.Inventory.exception.ProductOutOfStockException;
import com.laarizag.Inventory.model.Order;
import com.laarizag.Inventory.model.Product;
import com.laarizag.Inventory.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductService productService;

    @SneakyThrows
    public Order generateOrder(Order newOrder) {
        for(var orderDetail : newOrder.getOrderDetailSet()) {
            var product = productService.getProductById(orderDetail.getProduct().getId());
            var difference = product.getStock() - orderDetail.getQuantity();
            if(difference > 10) throw new ProductOutOfStockException();
            else if(difference > 5) product.setStock(product.getStock() + callTenRestocker().getStock());
            else callFiveRestocker(product.getId());

            productService.removeStock(orderDetail.getProduct().getId(), orderDetail.getQuantity());
        }

        orderRepository.save(newOrder);
        return newOrder;

    }

    public RestockWrapper callTenRestocker() {
        String uriTenReStocker = "https://mocki.io/v1/3196cd14-0fce-41f2-86f7-91b75d175ada";
        return WebClient.create(uriTenReStocker)
                .get()
                .retrieve()
                .bodyToMono(RestockWrapper.class)
                .block();
    }

    public Mono<RestockWrapper> callFiveRestocker(Long productId) {
        String uriFiveReStocker = "https://mocki.io/v1/37574cbc-df5d-4252-b089-9e422ce9b7c1";
        return WebClient.create(uriFiveReStocker)
                .get()
                .retrieve()
                .bodyToMono(RestockWrapper.class)
                .map(restockWrapper -> {
                    productService.addStock(productId, restockWrapper.getStock());
                    return restockWrapper;
                });
    }

}
