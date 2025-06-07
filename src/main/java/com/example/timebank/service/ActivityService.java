package com.example.timebank.service;

import com.example.timebank.dto.ActivityDto;

import java.util.List;

public interface ActivityService {
    ActivityDto create(ActivityDto dto);
    List<ActivityDto> findAll();
}
