package com.example.week4.repository;

import com.example.week4.entity.Product;
import com.example.week4.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {


}
