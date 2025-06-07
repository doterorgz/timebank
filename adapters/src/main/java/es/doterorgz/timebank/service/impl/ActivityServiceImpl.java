package es.doterorgz.timebank.service.impl;

import es.doterorgz.timebank.domain.Activity;
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

    @Override
    public Activity create(Activity activity) {
        return repository.save(activity);
    }

    @Override
    public List<Activity> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Activity> findByLocation(double latitude, double longitude, double distance) {
        return repository.findByLocation(latitude, longitude, distance);
    }

    @Override
    public List<Activity> searchByText(String text) {
        return repository.searchByText(text);
    }

    @Override
    public List<Activity> findByDateRange(LocalDateTime start, LocalDateTime end) {
        return repository.findByDateRange(start, end);
    }

    @Override
    public List<Activity> search(double latitude, double longitude, double distance, String text,
                                LocalDateTime start, LocalDateTime end) {
        return repository.search(latitude, longitude, distance, text, start, end);
    }
}
