package com.example.week4.entity;
import com.example.week4.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "order")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String productName;
    @Enumerated(EnumType.STRING)
    private Status status;
    private int productId;
    private int userId;
    private LocalDateTime orderDate;
    private int quantity;

    public Order(int id, String productName, int userId) {

    }
}
