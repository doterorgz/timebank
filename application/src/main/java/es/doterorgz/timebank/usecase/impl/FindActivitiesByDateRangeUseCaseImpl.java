package es.doterorgz.timebank.usecase.impl;

import es.doterorgz.timebank.domain.Activity;
import es.doterorgz.timebank.service.ActivityService;
import es.doterorgz.timebank.usecase.FindActivitiesByDateRangeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FindActivitiesByDateRangeUseCaseImpl implements FindActivitiesByDateRangeUseCase {

    private final ActivityService activityService;

    @Override
    public List<Activity> execute(LocalDateTime start, LocalDateTime end) {
        return activityService.findByDateRange(start, end);
    }
}
