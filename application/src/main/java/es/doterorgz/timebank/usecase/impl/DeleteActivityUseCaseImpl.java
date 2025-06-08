package es.doterorgz.timebank.usecase.impl;

import es.doterorgz.timebank.service.ActivityService;
import es.doterorgz.timebank.usecase.DeleteActivityUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteActivityUseCaseImpl implements DeleteActivityUseCase {

    private final ActivityService activityService;

    @Override
    public void execute(Long id) {
        activityService.delete(id);
    }
}
