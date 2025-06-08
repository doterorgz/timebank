package es.doterorgz.timebank.usecase;

import es.doterorgz.timebank.domain.Activity;

public interface FindActivityByIdUseCase {
    Activity execute(Long id);
}
