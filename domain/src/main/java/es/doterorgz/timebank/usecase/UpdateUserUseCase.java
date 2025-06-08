package es.doterorgz.timebank.usecase;

import es.doterorgz.timebank.domain.User;

public interface UpdateUserUseCase {
    User execute(Long id, User user);
}
