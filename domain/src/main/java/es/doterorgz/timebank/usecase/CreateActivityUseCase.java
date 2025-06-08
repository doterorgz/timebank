package es.doterorgz.timebank.usecase;

import es.doterorgz.timebank.domain.Activity;

public interface CreateActivityUseCase {
    Activity execute(Activity activity);
}
