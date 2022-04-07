package com.laarizag.Inventory.service;

import com.laarizag.Inventory.dto.GenerateOrderRequest;
import com.laarizag.Inventory.dto.RestockWrapper;
import com.laarizag.Inventory.exception.ProductOutOfStockException;
import com.laarizag.Inventory.model.Order;
import com.laarizag.Inventory.model.OrderDetail;
import com.laarizag.Inventory.repository.OrderDetailRepository;
import com.laarizag.Inventory.repository.OrderModelRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final OrderModelRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final ProductService productService;
    private final ClientService clientService;
    private final StoreService storeService;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public void generateOrder(GenerateOrderRequest request) throws ProductOutOfStockException {
        var order = new Order();

        order.setClient(clientService.getClientById(request.getClient()));
        Set<OrderDetail> orderDetails = new HashSet<>();
        for(var orderDetail : request.getDetails()) {
            var product = productService.getProductById(orderDetail.getProduct());
            var difference = orderDetail.getQuantity() - product.getStock();
            if(difference > 10) throw new ProductOutOfStockException();
            else if(difference > 5) product.setStock(product.getStock() + callTenRestocker().getStock());
            else if(difference > 0) callFiveRestocker(product.getId());

            productService.removeStock(orderDetail.getProduct(), orderDetail.getQuantity());
            orderDetails.add(OrderDetail.builder()
                            .order(order)
                            .product(product)
                            .quantity(orderDetail.getQuantity())
                            .price(product.getPrice())
                            .store(storeService.getStoreById(orderDetail.getStore()))
                    .build());
        }
        order.setOrderDetailSet(orderDetails);
        order.setTotalPrice(order.calculateTotalPrice());
        orderDetailRepository.saveAll(order.getOrderDetailSet());
        orderRepository.save(order);

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
