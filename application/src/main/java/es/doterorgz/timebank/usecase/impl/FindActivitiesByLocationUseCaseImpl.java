package es.doterorgz.timebank.usecase.impl;

import es.doterorgz.timebank.domain.Activity;
import es.doterorgz.timebank.service.ActivityService;
import es.doterorgz.timebank.usecase.FindActivitiesByLocationUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindActivitiesByLocationUseCaseImpl implements FindActivitiesByLocationUseCase {

    private final ActivityService activityService;

    @Override
    public List<Activity> execute(double latitude, double longitude, double distance) {
        return activityService.findByLocation(latitude, longitude, distance);
    }
}
