package com.example.week4.service;

import com.example.week4.dto.product.RequestProductDto;
import com.example.week4.entity.Product;
import com.example.week4.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;


    public Product createProduct(RequestProductDto requestProductDto) {
        return null;
    }

    public void deleteProduct(int productId) {

    }
}