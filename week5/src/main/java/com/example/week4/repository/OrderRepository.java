package com.example.week4.repository;

import com.example.week4.dto.order.RequestOrderDTO;
import com.example.week4.dto.order.ResponseOrderDto;
import com.example.week4.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface OrderRepository extends JpaRepository<User, Integer> {

    ResponseOrderDto createOrder(RequestOrderDTO requestOrderDto);

    ResponseOrderDto getOrderById(int orderId);

    ResponseOrderDto updateOrder(int id, ResponseOrderDto orderDto);
}
