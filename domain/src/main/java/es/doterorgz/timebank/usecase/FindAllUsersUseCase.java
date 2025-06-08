package es.doterorgz.timebank.usecase;

import es.doterorgz.timebank.domain.User;
import java.util.List;

public interface FindAllUsersUseCase {
    List<User> execute();
}
