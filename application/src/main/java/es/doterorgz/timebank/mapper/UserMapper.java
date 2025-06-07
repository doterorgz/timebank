package es.doterorgz.timebank.mapper;

import es.doterorgz.timebank.domain.User;
import es.doterorgz.timebank.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(UserDto dto);
}
