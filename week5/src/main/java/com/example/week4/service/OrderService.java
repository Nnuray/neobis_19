package com.example.week4.service;

import com.example.week4.dto.order.RequestOrderDTO;
import com.example.week4.dto.order.ResponseOrderDto;
import com.example.week4.dto.order.ResponseOrderDto;
import com.example.week4.dto.user.ResponseUserDto;
import com.example.week4.entity.Order;
import com.example.week4.enums.Status;
import com.example.week4.repository.OrderRepository;
import com.example.week4.repository.ProductRepository;
import com.example.week4.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public static ResponseOrderDto createOrder(RequestOrderDTO requestOrderDTO) {
        Order order = new Order(requestOrderDTO.getId(), requestOrderDTO.getProductName(), requestOrderDTO.getUserId());
        order.setStatus(Status.ACTIVE);
        return new ResponseOrderDto(order.getId(), order.getProductName(), order.getStatus(), order.getProductId(), order.getUserId());
    }
    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }

    public ResponseUserDto getOrderById(int id) {
        return null;
    }
}
