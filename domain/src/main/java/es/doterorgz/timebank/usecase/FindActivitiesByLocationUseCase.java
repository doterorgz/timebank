package es.doterorgz.timebank.usecase;

import es.doterorgz.timebank.domain.Activity;
import java.util.List;

public interface FindActivitiesByLocationUseCase {
    List<Activity> execute(double latitude, double longitude, double distance);
}
