package com.example.week4.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component // управляемый контейнер спринг
@RequiredArgsConstructor

public class JwtAuthFilter extends OncePerRequestFilter { // добавили фильтр для одного раза для каждого запроса
    private final JwtService jwtService;
    @Override
    protected void doFilterInternal(  // проверка токена для авторизации
            @NonNull HttpServletRequest request, // предоставить запрос на сервер
            @NonNull HttpServletResponse response, // предоставить ответ для клиента
            @NonNull FilterChain filterChain // создержит цепочку дургих фильтров
    ) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization"); // заголовок
        final String jwt;
        final String username;
        if(authHeader == null || !authHeader.startsWith("Bearer ")){  // проверка заголовка
            filterChain.doFilter(request,response); // передвет по цепочке следуещему фильтру
            return;
        }
        jwt = authHeader.substring(7); // bearer 6 букв и оно удаляяется
        username = jwtService.extractUsername(jwt);
    }
}
