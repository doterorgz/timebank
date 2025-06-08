package es.doterorgz.timebank.usecase.impl;

import es.doterorgz.timebank.service.UserService;
import es.doterorgz.timebank.usecase.DeleteUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteUserUseCaseImpl implements DeleteUserUseCase {

    private final UserService userService;

    @Override
    public void execute(Long id) {
        userService.delete(id);
    }
}
