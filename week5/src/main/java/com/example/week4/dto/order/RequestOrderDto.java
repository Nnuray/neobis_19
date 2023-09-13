package com.example.week4.dto.order;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestOrderDto {
    private int productId;
    private int quantity;

}
