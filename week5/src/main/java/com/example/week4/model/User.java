package com.example.week4.model;

import com.example.week4.enums.Role;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String first_name;
    private String last_name;
    private String phone;
    private String email;
    private String status;
    @Enumerated(EnumType.STRING)
    private Role role;

}
