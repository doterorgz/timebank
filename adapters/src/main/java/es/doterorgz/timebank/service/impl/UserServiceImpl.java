package es.doterorgz.timebank.service.impl;

import es.doterorgz.timebank.domain.User;
import es.doterorgz.timebank.repository.UserRepository;
import es.doterorgz.timebank.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
