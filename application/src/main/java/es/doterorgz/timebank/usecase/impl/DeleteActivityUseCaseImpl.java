package es.doterorgz.timebank.usecase.impl;

import es.doterorgz.timebank.service.ActivityService;
import es.doterorgz.timebank.usecase.DeleteActivityUseCase;
import lombok.RequiredArgsConstructor;
import es.doterorgz.timebank.logging.Loggable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteActivityUseCaseImpl implements DeleteActivityUseCase {

    private final ActivityService activityService;

    @Override
    @Loggable
    public void execute(Long id) {
        activityService.delete(id);
    }
}
