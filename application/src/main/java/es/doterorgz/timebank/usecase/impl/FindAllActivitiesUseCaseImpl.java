package es.doterorgz.timebank.usecase.impl;

import es.doterorgz.timebank.domain.Activity;
import es.doterorgz.timebank.service.ActivityService;
import es.doterorgz.timebank.usecase.FindAllActivitiesUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindAllActivitiesUseCaseImpl implements FindAllActivitiesUseCase {

    private final ActivityService activityService;

    @Override
    public List<Activity> execute() {
        return activityService.findAll();
    }
}
