package com.example.spring.service;

import com.example.spring.api.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private List<User> userList;
    private List<User> allUsers;

    public UserService(){
        userList = new ArrayList<>();

        User user1 = new User(20785,"Nuray", "Kavkayeva","87779862561","nuray.kavkayev.04@gmail.com","status", "role");
        User user2 = new User(54504,"Ali", "Kavkayev","87788625611","ali@gmail.com","status", "role");
        User user3 = new User(78458,"Salman", "Kavkayev","87073862561","salman@gmail.com","status", "role");
        User user4 = new User(47804,"Erkezhan", "Akbanova","87475962587","erke@gmail.com","status", "role");
        User user5 = new User(14780,"Aika", "Arystan","87028625789","aika@gmail.com","status", "role");

        userList.addAll(Arrays.asList(user1,user2,user3,user4,user5));
    }
    public Optional<User> getUser(Integer id) {
        Optional optional = Optional.empty();
        for(User user: userList){
            if(id == user.getId()){
                optional = Optional.of(user);
                return optional;
            }
        }
        return optional;
    }

    public User createUser(User user) {
        User o = null;
        return user;
    }

    public User updateUser(User user, User updatedUser) {
        return user;
    }

    public void deleteUser(User user) {
    }

    public List<User> getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(List<User> allUsers) {
        this.allUsers = allUsers;
    }
}
