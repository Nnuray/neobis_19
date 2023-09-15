package com.example.week4.controller;

import com.example.week4.dto.order.RequestOrderDto;
import com.example.week4.dto.order.ResponseOrderDto;
import com.example.week4.dto.user.ResponseUserDto;
import com.example.week4.entity.User;
import com.example.week4.service.OrderService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/{id}")
    @SecurityRequirement(name = "JWT") // Требование JWT токена в сваггере
    public ResponseEntity<ResponseOrderDto> getOderById(@PathVariable int id){
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @PostMapping("/create")
    @SecurityRequirement(name = "JWT")
    public ResponseOrderDto createOrder(@RequestBody RequestOrderDto orderDto,
                                        @AuthenticationPrincipal User user) {
        return orderService.createOrder(orderDto, user);
    }
}
