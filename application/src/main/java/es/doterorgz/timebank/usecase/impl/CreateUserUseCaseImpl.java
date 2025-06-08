package es.doterorgz.timebank.usecase.impl;

import es.doterorgz.timebank.domain.User;
import es.doterorgz.timebank.service.UserService;
import es.doterorgz.timebank.usecase.CreateUserUseCase;
import es.doterorgz.timebank.logging.Loggable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserService userService;

    @Override
    @Loggable
    public User execute(User user) {
        return userService.create(user);
    }
}
