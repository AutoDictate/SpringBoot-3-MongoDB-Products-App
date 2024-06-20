package com.mongodb.service;

import java.util.List;

import com.mongodb.entity.Product;
import com.mongodb.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public String save(Product product) {
    return repository.save(product).getId();
  }

  public Product findById(String id) {
    return repository.findById(id)
        .orElse(null);
  }

  public List<Product> findAll() {
    return repository.findAll();
  }

  public void delete(String id) {
    repository.deleteById(id);
  }

}
