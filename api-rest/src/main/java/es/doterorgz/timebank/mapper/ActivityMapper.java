package es.doterorgz.timebank.mapper;

import es.doterorgz.timebank.domain.Activity;
import es.doterorgz.timebank.dto.ActivityDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ActivityMapper {
    ActivityDto toDto(Activity activity);

    Activity toEntity(ActivityDto dto);
}
