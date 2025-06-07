package es.doterorgz.timebank.mapper;

import es.doterorgz.timebank.adapters.entities.ActivityEntity;
import es.doterorgz.timebank.domain.Activity;
import org.mapstruct.Mapper;

/**
 * Maps between {@link Activity} domain objects and their JPA {@link ActivityEntity}
 * counterparts.
 */
@Mapper(componentModel = "spring")
public interface ActivityEntityMapper {

    ActivityEntity toEntity(Activity activity);

    Activity toDomain(ActivityEntity entity);
}

