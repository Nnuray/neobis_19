package com.example.week4.dto.order;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestOrderDTO {
    private int id;
    private String productName;
    private String status;
    private int productId;
    private int userId;

}
