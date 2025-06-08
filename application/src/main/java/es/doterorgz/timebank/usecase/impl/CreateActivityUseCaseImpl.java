package es.doterorgz.timebank.usecase.impl;

import es.doterorgz.timebank.domain.Activity;
import es.doterorgz.timebank.service.ActivityService;
import es.doterorgz.timebank.usecase.CreateActivityUseCase;
import es.doterorgz.timebank.logging.Loggable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateActivityUseCaseImpl implements CreateActivityUseCase {

    private final ActivityService activityService;

    @Override
    @Loggable
    public Activity execute(Activity activity) {
        return activityService.create(activity);
    }
}
