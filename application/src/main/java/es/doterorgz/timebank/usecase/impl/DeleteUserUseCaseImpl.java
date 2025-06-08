package es.doterorgz.timebank.usecase.impl;

import es.doterorgz.timebank.service.UserService;
import es.doterorgz.timebank.usecase.DeleteUserUseCase;
import lombok.RequiredArgsConstructor;
import es.doterorgz.timebank.logging.Loggable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteUserUseCaseImpl implements DeleteUserUseCase {

    private final UserService userService;

    @Override
    @Loggable
    public void execute(Long id) {
        userService.delete(id);
    }
}
