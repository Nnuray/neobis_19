package com.example.week4.controller;

import com.example.week4.dto.order.RequestOrderDTO;
import com.example.week4.dto.order.ResponseOrderDto;
import com.example.week4.dto.user.ResponseUserDto;
import com.example.week4.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class orderController {
    private final OrderService orderService;
    @Autowired
    public orderController(OrderService orderService){
        this.orderService=orderService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseOrderDto> getOderById(@PathVariable int id){
        ResponseUserDto user = orderService.getOrderById(id);
        if(user == null){
            return ResponseEntity.notFound().build();
        }
        ResponseOrderDto responseOrderDto = new
                ResponseOrderDto();
        return ResponseEntity.ok(responseOrderDto);
    }

    @PostMapping("/{CreateOrder")
    public void createOrder(@RequestBody RequestOrderDTO orderDto) {
        OrderService.createOrder(orderDto);
    }
}
