package es.doterorgz.timebank.usecase.impl;

import es.doterorgz.timebank.domain.Activity;
import es.doterorgz.timebank.service.ActivityService;
import es.doterorgz.timebank.usecase.FindActivityByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindActivityByIdUseCaseImpl implements FindActivityByIdUseCase {

    private final ActivityService activityService;

    @Override
    public Activity execute(Long id) {
        return activityService.findById(id);
    }
}
