package com.example.timebank.mapper;

import com.example.timebank.domain.Activity;
import com.example.timebank.dto.ActivityDto;
import com.example.timebank.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ActivityMapper {
    @Mapping(target = "instructorId", source = "instructor.id")
    @Mapping(target = "participantIds", source = "participants", qualifiedByName = "userToId")
    ActivityDto toDto(Activity activity);

    @Mapping(target = "instructor.id", source = "instructorId")
    @Mapping(target = "participants", source = "participantIds", qualifiedByName = "idToUser")
    Activity toEntity(ActivityDto dto);

    @Named("userToId")
    static Long mapUserToId(User user) {
        return user.getId();
    }

    @Named("idToUser")
    static User mapIdToUser(Long id) {
        if (id == null) return null;
        User user = new User();
        user.setId(id);
        return user;
    }
}
