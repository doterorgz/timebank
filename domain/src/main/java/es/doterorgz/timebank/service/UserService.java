package es.doterorgz.timebank.service;

import es.doterorgz.timebank.domain.User;

import java.util.List;

public interface UserService {
    User create(User user);

    List<User> findAll();
}
