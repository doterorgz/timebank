package es.doterorgz.timebank.usecase;

import es.doterorgz.timebank.domain.User;

public interface CreateUserUseCase {
    User execute(User user);
}
