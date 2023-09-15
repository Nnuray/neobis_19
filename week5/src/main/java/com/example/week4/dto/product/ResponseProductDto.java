package com.example.week4.dto.product;

import com.example.week4.entity.Product;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseProductDto {
    private int id;
    private String productName;
    private double price;
    private float score;

    public static ResponseProductDto toResponseProductDTO(Product product){
        return ResponseProductDto.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .price(product.getPrice())
                .score(product.getScore())
                .build();
    }
}
