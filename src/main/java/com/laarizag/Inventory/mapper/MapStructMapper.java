package com.laarizag.Inventory.mapper;

import com.laarizag.Inventory.dto.model.ClientDto;
import com.laarizag.Inventory.dto.model.OrderDto;
import com.laarizag.Inventory.dto.model.ProductDto;
import com.laarizag.Inventory.dto.model.StoreDto;
import com.laarizag.Inventory.model.Client;
import com.laarizag.Inventory.model.Order;
import com.laarizag.Inventory.model.Product;
import com.laarizag.Inventory.model.Store;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructMapper {

    ClientDto clientToDto(Client client);

    ProductDto productToDto(Product product);

    StoreDto storeToDto(Store store);

    OrderDto orderToDto(Order order);

}
