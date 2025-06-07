package com.example.timebank.mapper;

import com.example.timebank.domain.User;
import com.example.timebank.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(UserDto dto);
}
