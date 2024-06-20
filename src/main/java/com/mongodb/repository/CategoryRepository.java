package com.mongodb.repository;

import com.mongodb.entity.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository
    extends MongoRepository<Category, String> {

}
