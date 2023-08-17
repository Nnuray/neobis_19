package com.example.week4.dto;

import com.example.week4.model.User;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseUserDto {
    private int id;
    private String first_name;
    private String last_name;
    private String phone;
    private String email;
    private String status;
    private String role;

    public static ResponseUserDto toResponseUserDto(User user) {//конвертировать одного юсера
        return ResponseUserDto.builder()
                .id(user.getId())
                .first_name(user.getFirst_name())
                .last_name(user.getLast_name())
                .phone(user.getPhone())
                .email(user.getEmail())
                .status(user.getStatus())
                .role(user.getRole().name())
                .build();
    }

    public static List<ResponseUserDto> toResponseUserDtos(List<User> users) {
        return users.stream().map(ResponseUserDto::toResponseUserDto).toList();
    }
}
