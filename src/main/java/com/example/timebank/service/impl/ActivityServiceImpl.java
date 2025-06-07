package com.example.timebank.service.impl;

import com.example.timebank.dto.ActivityDto;
import com.example.timebank.mapper.ActivityMapper;
import com.example.timebank.repository.ActivityRepository;
import com.example.timebank.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService {
    private final ActivityRepository repository;
    private final ActivityMapper mapper;

    @Override
    public ActivityDto create(ActivityDto dto) {
        var entity = mapper.toEntity(dto);
        var saved = repository.save(entity);
        return mapper.toDto(saved);
    }

    @Override
    public List<ActivityDto> findAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }
}
