package es.doterorgz.timebank.service.impl;

import es.doterorgz.timebank.adapters.entities.ActivityEntity;
import es.doterorgz.timebank.domain.Activity;
import es.doterorgz.timebank.mapper.ActivityEntityMapper;
import es.doterorgz.timebank.repository.ActivityRepository;
import es.doterorgz.timebank.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService {
    private final ActivityRepository repository;
    private final ActivityEntityMapper mapper;

    @Override
    public Activity create(Activity activity) {
        ActivityEntity entity = mapper.toEntity(activity);
        ActivityEntity saved = repository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public List<Activity> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public Activity findById(Long id) {
        return repository.findById(id).map(mapper::toDomain).orElse(null);
    }

    @Override
    public Activity update(Long id, Activity activity) {
        ActivityEntity entity = mapper.toEntity(activity);
        entity.setId(id);
        ActivityEntity saved = repository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Activity> findByLocation(double latitude, double longitude, double distance) {
        return repository.findByLocation(latitude, longitude, distance).stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public List<Activity> searchByText(String text) {
        return repository.searchByText(text).stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public List<Activity> findByDateRange(LocalDateTime start, LocalDateTime end) {
        return repository.findByDateRange(start, end).stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public List<Activity> search(double latitude, double longitude, double distance, String text,
                                LocalDateTime start, LocalDateTime end) {
        return repository.search(latitude, longitude, distance, text, start, end)
                .stream().map(mapper::toDomain).toList();
    }
}
