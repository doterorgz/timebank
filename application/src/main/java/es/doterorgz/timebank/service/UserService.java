package es.doterorgz.timebank.service;

import es.doterorgz.timebank.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto create(UserDto user);
    List<UserDto> findAll();
}
