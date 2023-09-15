package com.example.week4.dto.order;

import com.example.week4.dto.product.ResponseProductDto;
import com.example.week4.dto.product.ResponseProductDto;
import com.example.week4.dto.user.ResponseUserDto;
import com.example.week4.entity.Order;
import com.example.week4.enums.Status;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.util.List;

import static com.example.week4.dto.product.ResponseProductDto.toResponseProductDTO;
import static com.example.week4.dto.user.ResponseUserDto.toResponseUserDto;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseOrderDto {
    private int id;
    private String status;
    private ResponseProductDto product;
    private ResponseUserDto user;

    public static ResponseOrderDto toResponseOrderDTO(Order order){
        return ResponseOrderDto.builder()
                .id(order.getId())
                .status(order.getStatus().name())
                .user(toResponseUserDto(order.getUser()))
                .product(toResponseProductDTO(order.getProduct()))
                .build();
    }

    public static List<ResponseOrderDto> toResponseOrderDTOs(List<Order> orders){
        return orders.stream().map(ResponseOrderDto::toResponseOrderDTO).toList();
    }

}
