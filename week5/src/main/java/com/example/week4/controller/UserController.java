package com.example.week4.controller;

import com.example.week4.dto.user.RequestUserDto;
import com.example.week4.dto.user.ResponseUserDto;
import com.example.week4.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/hello")
    public String hello(){
        return "<h2> hey, user</h2>";
    }

    @GetMapping("/{id}")   //endpoint1
    @SecurityRequirement(name = "JWT")
    public ResponseEntity<ResponseUserDto> getUserById(@PathVariable int id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping("/createUser")    //endpoint2
    @SecurityRequirement(name = "JWT")
    public void createUser(@RequestBody RequestUserDto userDto) {
        userService.createUser(userDto);
    }

    @PutMapping("/update/{id}")   //endpoints3
    @SecurityRequirement(name = "JWT")
    public void updateUser(@PathVariable int id, @RequestBody ResponseUserDto responseUserDto, @PathVariable String updateById) {
            userService.updateUser(id, responseUserDto);
        }

    @DeleteMapping("/delete/{id}")  //endpoint4
    @SecurityRequirement(name = "JWT")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @GetMapping("/getAllUsers")
    @SecurityRequirement(name = "JWT")
    public List<ResponseUserDto> getAllUsers() {
        return userService.getAllUsers();
    }



}

