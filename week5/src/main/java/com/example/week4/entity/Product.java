package com.example.week4.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity // чтобы сделать этот клас как сущность
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String productName;
    private double price;
    @Column(name = "score", nullable = false, columnDefinition = "float")
    private float score;
}
