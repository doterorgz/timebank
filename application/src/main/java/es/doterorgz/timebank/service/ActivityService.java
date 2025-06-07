package es.doterorgz.timebank.service;

import es.doterorgz.timebank.dto.ActivityDto;

import java.util.List;

public interface ActivityService {
    ActivityDto create(ActivityDto dto);
    List<ActivityDto> findAll();
}
