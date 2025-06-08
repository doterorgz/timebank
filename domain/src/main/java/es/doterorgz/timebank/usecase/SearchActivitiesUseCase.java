package es.doterorgz.timebank.usecase;

import es.doterorgz.timebank.domain.Activity;
import java.time.LocalDateTime;
import java.util.List;

public interface SearchActivitiesUseCase {
    List<Activity> execute(double latitude, double longitude, double distance, String text, LocalDateTime start, LocalDateTime end);
}
