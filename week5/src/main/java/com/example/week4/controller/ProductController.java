package com.example.week4.controller;

import com.example.week4.dto.product.RequestProductDto;
import com.example.week4.dto.product.ResponseProductDto;
import com.example.week4.entity.Product;
import com.example.week4.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping("/createProduct")
    public ResponseEntity<ResponseProductDto> createProduct(@RequestBody RequestProductDto requestProductDto) {
        Product createdProduct = productService.createProduct(requestProductDto);
        ResponseProductDto responseProductDto = ResponseProductDto.toResponseProductDTO(createdProduct);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseProductDto);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }

}
