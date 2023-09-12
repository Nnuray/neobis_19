package com.example.week4.service;

import com.example.week4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {

   //private final ProductRepository ProductRepository;

    @Autowired
    public ProductService(UserRepository userRepository) {
  //      this.ProductRepository = userRepository;
    }

  }