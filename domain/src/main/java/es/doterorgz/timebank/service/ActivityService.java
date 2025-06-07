package es.doterorgz.timebank.service;

import es.doterorgz.timebank.domain.Activity;

import java.time.LocalDateTime;
import java.util.List;

public interface ActivityService {
    Activity create(Activity activity);

    List<Activity> findAll();

    List<Activity> findByLocation(double latitude, double longitude, double distance);

    List<Activity> searchByText(String text);

    List<Activity> findByDateRange(LocalDateTime start, LocalDateTime end);

    List<Activity> search(double latitude, double longitude, double distance, String text,
                          LocalDateTime start, LocalDateTime end);
}
