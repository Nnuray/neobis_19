package com.example.week4.dto.order;

import com.example.week4.enums.Status;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseOrderDto {
    private int id;
    private String productName;
    private String status;
    private int productId;
    private int userId;

    public ResponseOrderDto(int id, String productName, Status status, int productId, int userId) {

    }
}
