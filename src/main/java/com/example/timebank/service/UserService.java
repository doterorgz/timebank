package com.example.timebank.service;

import com.example.timebank.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto create(UserDto user);
    List<UserDto> findAll();
}
