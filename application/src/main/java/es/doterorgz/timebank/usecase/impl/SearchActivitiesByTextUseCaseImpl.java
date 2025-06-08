package es.doterorgz.timebank.usecase.impl;

import es.doterorgz.timebank.domain.Activity;
import es.doterorgz.timebank.service.ActivityService;
import es.doterorgz.timebank.usecase.SearchActivitiesByTextUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SearchActivitiesByTextUseCaseImpl implements SearchActivitiesByTextUseCase {

    private final ActivityService activityService;

    @Override
    public List<Activity> execute(String text) {
        return activityService.searchByText(text);
    }
}
