package es.doterorgz.timebank.usecase.impl;

import es.doterorgz.timebank.domain.User;
import es.doterorgz.timebank.service.UserService;
import es.doterorgz.timebank.usecase.FindUserByIdUseCase;
import es.doterorgz.timebank.logging.Loggable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindUserByIdUseCaseImpl implements FindUserByIdUseCase {

    private final UserService userService;

    @Override
    @Loggable
    public User execute(Long id) {
        return userService.findById(id);
    }
}
