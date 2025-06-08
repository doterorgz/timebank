package es.doterorgz.timebank.usecase;

import es.doterorgz.timebank.domain.Activity;
import java.util.List;

public interface SearchActivitiesByTextUseCase {
    List<Activity> execute(String text);
}
