package com.service;

import com.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductService {

    public List<Product> findAll() throws Exception;

    void save(Product product);
}
