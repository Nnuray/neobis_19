package com.example.week4.service;

import com.example.week4.dto.RequestUserDto;
import com.example.week4.dto.ResponseUserDto;
import com.example.week4.enums.Role;
import com.example.week4.model.User;
import com.example.week4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.week4.dto.ResponseUserDto.toResponseUserDto;
import static com.example.week4.dto.ResponseUserDto.toResponseUserDtos;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseUserDto getUserById(int id) {
        return toResponseUserDto(userRepository.findById(id).get());
    }
    public String createUser(RequestUserDto userDto) {
        User user = User.builder()
                .first_name(userDto.getFirst_name())
                .last_name(userDto.getLast_name())
                .phone(userDto.getPhone())
                .status(userDto.getStatus())
                .email(userDto.getEmail())
                .role(Role.USER)
                .build();
        userRepository.save(user);
        return "Пользователь создан";
    }

    public ResponseUserDto updateUser(int id, ResponseUserDto userDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Пользователь с таким айди не найден"));

        user.setFirst_name(userDto.getFirst_name());
        user.setLast_name(userDto.getLast_name());
        user.setPhone(userDto.getPhone());
        user.setEmail(userDto.getEmail());

        userRepository.save(user);
        return toResponseUserDto(user);
    }

    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }

    public List<ResponseUserDto> getAllUsers() {
        return toResponseUserDtos(userRepository.findAll());
    }


}