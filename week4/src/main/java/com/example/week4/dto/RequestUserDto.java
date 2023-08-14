package com.example.week4.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestUserDto {
    private String first_name;
    private String last_name;
    private String phone;
    private String email;
    private String status;
}
