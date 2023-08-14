package com.example.week4.service;

import com.example.week4.dto.RequestUserDto;
import com.example.week4.dto.ResponseUserDto;
import com.example.week4.enums.Role;
import com.example.week4.model.User;
import com.example.week4.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.week4.dto.ResponseUserDto.toResponseUserDtos;

@Service
public class UserService {
    private final UserRepository userRepository;
    private List<ResponseUserDto> userList;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository; //эти данные должны лежать в бд
    }
    public ResponseUserDto getUser(Integer id) {
        return ResponseUserDto.toResponseUserDto(userRepository.findById(id).get());
    }

    public ResponseUserDto getUserById(int id) {
        for (ResponseUserDto user : userList) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
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

    public User updateUser(int id, ResponseUserDto userDto) {
        for(ResponseUserDto user : userList) {
            if (user.getId() == id) {
                user.setId(userDto.getId());
                user.setFirst_name(userDto.getFirst_name());
                user.setLast_name(userDto.getLast_name());
                user.setPhone(userDto.getPhone());
                user.setEmail(userDto.getEmail());
                user.setStatus(userDto.getStatus());
                user.setRole(userDto.getRole());
            }
        }

        return null;
    }

  //  public void deleteUser(ResponseUserDto user) {
  //      userRepository.delete(user);
  //  }

    public List<ResponseUserDto> getAllUsers() {
        return toResponseUserDtos(userRepository.findAll());
    }


}