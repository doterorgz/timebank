package es.doterorgz.timebank.usecase;

import es.doterorgz.timebank.domain.User;

public interface FindUserByIdUseCase {
    User execute(Long id);
}
