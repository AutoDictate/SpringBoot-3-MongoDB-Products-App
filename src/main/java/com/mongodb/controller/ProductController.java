package com.mongodb.controller;

import java.math.BigDecimal;
import java.util.List;

import com.mongodb.entity.Product;
import com.mongodb.service.ProductService;
import com.mongodb.service.SearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

  private final ProductService service;
  private final SearchService searchService;

    public ProductController(ProductService service, SearchService searchService) {
        this.service = service;
        this.searchService = searchService;
    }

    @PostMapping
  public ResponseEntity<String> save(@RequestBody Product product) {
    return ResponseEntity.ok(service.save(product));
  }

  @GetMapping
  public ResponseEntity<List<Product>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }

  @GetMapping("/{product-id}")
  public ResponseEntity<Product> findById(@PathVariable("product-id") String productId) {
    return ResponseEntity.ok(service.findById(productId));
  }

  @DeleteMapping("/{product-id}")
  public ResponseEntity<Void> delete(@PathVariable("product-id") String productId) {
    service.delete(productId);
    return ResponseEntity.accepted().build();
  }

  @GetMapping("/search/is")
  public ResponseEntity<List<Product>> searchByName(@RequestParam("name") String name) {
    return ResponseEntity.ok(searchService.searchByName(name));
  }

  @GetMapping("/search/starts-with")
  public ResponseEntity<List<Product>> searchByNameStartsWith(@RequestParam("name") String name) {
    return ResponseEntity.ok(searchService.searchByNameStartingWith(name));
  }

  @GetMapping("/search/ends-with")
  public ResponseEntity<List<Product>> searchByNameEndsWith(@RequestParam("name") String name) {
    return ResponseEntity.ok(searchService.searchByNameEndingWith(name));
  }

  @GetMapping("/search/lt")
  public ResponseEntity<List<Product>> searchByPriceLt(@RequestParam("price") BigDecimal price) {
    return ResponseEntity.ok(searchService.searchByPriceLt(price));
  }

  @GetMapping("/search/gt")
  public ResponseEntity<List<Product>> searchByPriceGt(@RequestParam("price") BigDecimal price) {
    return ResponseEntity.ok(searchService.searchByPriceGt(price));
  }

  @GetMapping("/sort/asc")
  public ResponseEntity<List<Product>> searchByPriceGt(@RequestParam("field") String field) {
    return ResponseEntity.ok(searchService.sortAscByField(field));
  }

  @GetMapping("/sort-page")
  public ResponseEntity<List<Product>> sortAndPageByField(@RequestParam("field") String field) {
    return ResponseEntity.ok(searchService.sortAndPageByField(field));
  }
}
