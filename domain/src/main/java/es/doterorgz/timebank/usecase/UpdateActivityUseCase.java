package es.doterorgz.timebank.usecase;

import es.doterorgz.timebank.domain.Activity;

public interface UpdateActivityUseCase {
    Activity execute(Long id, Activity activity);
}
