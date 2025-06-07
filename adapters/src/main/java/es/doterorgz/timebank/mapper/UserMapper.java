package es.doterorgz.timebank.mapper;

import es.doterorgz.timebank.adapters.entities.ActivityEntity;
import es.doterorgz.timebank.domain.Activity;
import es.doterorgz.timebank.domain.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    ActivityEntity toDto(User activity);

    Activity toEntity(ActivityEntity activityDTO);
}
