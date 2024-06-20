package com.mongodb;

import com.mongodb.entity.Category;
import com.mongodb.repository.CategoryRepository;
import com.mongodb.entity.Product;
import com.mongodb.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Arrays;

@SpringBootApplication
public class MongoDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoDemoApplication.class, args);
	}

	// @Bean
	public CommandLineRunner commandLineRunner(
			ProductRepository repository,
			CategoryRepository categoryRepository
	) {
		return args -> {

			Category category1 = new Category("1","cat 1","cat 1");
			Category category2 = new Category("2","cat 2","cat 2");

			categoryRepository.insert(category1);
			categoryRepository.insert(category2);

			Product product1 = new Product(
					"1",
					"iPhone 13 Pro Max",
					"The iPhone 13 Pro Max features a 6.7-inch Super Retina XDR display and a new A15 Bionic chip for enhanced performance.",
					new BigDecimal("1099.99"),
					50,
					4.8,
					Arrays.asList("Apple", "Smartphone", "iOS", "5G"),
					new Category("1","Mobiles","Mobile Phones")
			);
		};
	}
}
