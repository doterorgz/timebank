package es.doterorgz.timebank.service;

import es.doterorgz.timebank.domain.User;

import java.util.List;

public interface UserService {
    User create(User user);

    List<User> findAll();

    User findById(Long id);

    User update(Long id, User user);

    void delete(Long id);
}
