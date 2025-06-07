package es.doterorgz.timebank.mapper;

import es.doterorgz.timebank.adapters.entities.ActivityEntity;
import es.doterorgz.timebank.domain.Activity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ActivityMapper {
    ActivityEntity toDto(Activity activity);

    Activity toEntity(ActivityEntity activityDTO);
}
