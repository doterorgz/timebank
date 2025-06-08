package es.doterorgz.timebank.usecase.impl;

import es.doterorgz.timebank.domain.Activity;
import es.doterorgz.timebank.service.ActivityService;
import es.doterorgz.timebank.usecase.FindActivitiesByDateRangeUseCase;
import es.doterorgz.timebank.logging.Loggable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class FindActivitiesByDateRangeUseCaseImpl implements FindActivitiesByDateRangeUseCase {

    private final ActivityService activityService;

    @Override
    @Loggable
    public List<Activity> execute(LocalDateTime start, LocalDateTime end) {
        return activityService.findByDateRange(start, end);
    }
}
