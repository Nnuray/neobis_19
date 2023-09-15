package com.example.week4.service;

import com.example.week4.dto.order.RequestOrderDto;
import com.example.week4.dto.order.ResponseOrderDto;
import com.example.week4.dto.user.ResponseUserDto;
import com.example.week4.entity.Order;
import com.example.week4.entity.Product;
import com.example.week4.entity.User;
import com.example.week4.enums.Status;
import com.example.week4.repository.OrderRepository;
import com.example.week4.repository.ProductRepository;
import com.example.week4.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.week4.dto.order.ResponseOrderDto.toResponseOrderDTO;


@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public ResponseOrderDto createOrder(RequestOrderDto requestOrderDTO, User user) {
        Product product = productRepository.findById(requestOrderDTO.getProductId())
                .orElseThrow(() -> new IllegalArgumentException("Product wasn't found"));

        Order order = Order.builder()
                .quantity(requestOrderDTO.getQuantity())
                .product(product)
                .user(user)
                .status(Status.ACTIVE)
                .build();
        orderRepository.save(order);
        return toResponseOrderDTO(order);
    }
    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }

    public ResponseOrderDto getOrderById(int id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));
        return toResponseOrderDTO(order);
    }
}
