package es.doterorgz.timebank.usecase.impl;

import es.doterorgz.timebank.domain.Activity;
import es.doterorgz.timebank.service.ActivityService;
import es.doterorgz.timebank.usecase.UpdateActivityUseCase;
import es.doterorgz.timebank.logging.Loggable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateActivityUseCaseImpl implements UpdateActivityUseCase {

    private final ActivityService activityService;

    @Override
    @Loggable
    public Activity execute(Long id, Activity activity) {
        return activityService.update(id, activity);
    }
}
