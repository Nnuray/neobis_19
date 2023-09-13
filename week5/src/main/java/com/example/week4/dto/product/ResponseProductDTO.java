package com.example.week4.dto.product;

import com.example.week4.entity.Product;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseProductDTO {
    private int id;
    private String productName;
    private double price;
    private float score;

    public static ResponseProductDTO toResponseProductDTO(Product product){
        return ResponseProductDTO.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .price(product.getPrice())
                .score(product.getScore())
                .build();
    }
}
