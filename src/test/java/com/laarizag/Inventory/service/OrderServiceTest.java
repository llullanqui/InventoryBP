package com.laarizag.Inventory.service;

import com.laarizag.Inventory.dto.GenerateOrderRequest;
import com.laarizag.Inventory.dto.GenerateOrderRequestDetail;
import com.laarizag.Inventory.dto.RestockWrapper;
import com.laarizag.Inventory.exception.ProductOutOfStockException;
import com.laarizag.Inventory.exception.StoreNotFoundException;
import com.laarizag.Inventory.model.Product;
import com.laarizag.Inventory.model.Store;
import com.laarizag.Inventory.repository.OrderDetailRepository;
import com.laarizag.Inventory.repository.OrderModelRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @MockBean
    private OrderModelRepository orderDetailRepository;

    @MockBean
    private OrderDetailRepository orderRepository;

    @MockBean
    private ProductService productService;

    @MockBean
    private ClientService clientService;

    @MockBean
    private StoreService storeService;

    @Test
    void shouldThrowOutOfStockException() {
        var request = GenerateOrderRequest.builder()
                .client(11L)
                .details(List.of(GenerateOrderRequestDetail.builder()
                                .product(1L)
                                .quantity(213)
                        .build()))
                .build();
        var mockProduct = Product.builder()
                .stock(2)
                .build();
        when(productService.getProductById(any(Long.class)))
                .thenReturn(mockProduct);

        assertThrows(ProductOutOfStockException.class, () -> orderService.generateOrder(request));
    }

    @Test
    void shouldReturnRestockWrapper() {
        var wrapper = orderService.callTenRestocker();

        assertThat(wrapper, Matchers.instanceOf(RestockWrapper.class));
    }

    @Test
    void shouldReturnRestockWrapperAsynchronously() {
        var mockProduct = Product.builder()
                .id(1L)
                .stock(2)
                .build();
        when(productService.getProductById(any(Long.class)))
                .thenReturn(mockProduct);
        var wrapper = orderService.callFiveRestocker(1L).block();

        assertThat(wrapper, Matchers.instanceOf(RestockWrapper.class));
    }



}
