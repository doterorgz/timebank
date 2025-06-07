package es.doterorgz.timebank.mapper;

import es.doterorgz.timebank.adapters.entities.UserEntity;
import es.doterorgz.timebank.domain.User;
import org.mapstruct.Mapper;

/**
 * Maps between {@link User} domain objects and their JPA {@link UserEntity}
 * counterparts.
 */
@Mapper(componentModel = "spring")
public interface UserEntityMapper {

    UserEntity toEntity(User user);

    User toDomain(UserEntity entity);
}

