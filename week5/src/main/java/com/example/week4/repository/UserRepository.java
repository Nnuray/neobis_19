package com.example.week4.repository;

import com.example.week4.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> { // идентификатор пользовательского класа

    // чтобы найти пользователя по электронной почте
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}
