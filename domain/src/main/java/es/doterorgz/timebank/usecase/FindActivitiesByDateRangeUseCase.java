package es.doterorgz.timebank.usecase;

import es.doterorgz.timebank.domain.Activity;
import java.time.LocalDateTime;
import java.util.List;

public interface FindActivitiesByDateRangeUseCase {
    List<Activity> execute(LocalDateTime start, LocalDateTime end);
}
