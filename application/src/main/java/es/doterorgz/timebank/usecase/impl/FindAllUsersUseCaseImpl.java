package es.doterorgz.timebank.usecase.impl;

import es.doterorgz.timebank.domain.User;
import es.doterorgz.timebank.service.UserService;
import es.doterorgz.timebank.usecase.FindAllUsersUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindAllUsersUseCaseImpl implements FindAllUsersUseCase {

    private final UserService userService;

    @Override
    public List<User> execute() {
        return userService.findAll();
    }
}
