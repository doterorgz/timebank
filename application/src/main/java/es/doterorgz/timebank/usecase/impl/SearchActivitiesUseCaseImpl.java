package es.doterorgz.timebank.usecase.impl;

import es.doterorgz.timebank.domain.Activity;
import es.doterorgz.timebank.service.ActivityService;
import es.doterorgz.timebank.usecase.SearchActivitiesUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchActivitiesUseCaseImpl implements SearchActivitiesUseCase {

    private final ActivityService activityService;

    @Override
    public List<Activity> execute(double latitude, double longitude, double distance, String text, LocalDateTime start, LocalDateTime end) {
        return activityService.search(latitude, longitude, distance, text, start, end);
    }
}
