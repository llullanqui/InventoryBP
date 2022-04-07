package com.laarizag.Inventory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.laarizag.Inventory.dto.ProductWrapper;
import com.laarizag.Inventory.model.Product;
import com.laarizag.Inventory.repository.ProductRepository;
import org.hibernate.SessionFactory;
import org.hibernate.ejb.HibernateEntityManagerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EntityScan("com.laarizag.Inventory.model")
public class InventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryApplication.class, args);
	}

	@Bean
	public WebClient localClient() {
		return WebClient.create("https://mocki.io/v1/e6f202bd-0f7e-48ff-a87e-2d3cfb0ae7a9");
	}

	@Bean
	CommandLineRunner runner(ProductRepository productRepository) {
		return args -> {
			try {
				var prods = localClient().get()
						.retrieve()
						.bodyToMono(ProductWrapper.class).block();
				assert prods != null;
				productRepository.saveAll(prods.getProds());
				System.out.println("Products Saved");
			} catch (Exception e) {
				System.out.println("Unable to save products: " + e.getMessage());
			}
		};
	}
}
