package es.doterorgz.timebank.service.impl;

import es.doterorgz.timebank.domain.User;
import es.doterorgz.timebank.adapters.entities.UserEntity;
import es.doterorgz.timebank.mapper.UserEntityMapper;
import es.doterorgz.timebank.repository.UserRepository;
import es.doterorgz.timebank.service.UserService;
import es.doterorgz.timebank.logging.Loggable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserEntityMapper mapper;

    @Override
    @Loggable
    public User create(User user) {
        UserEntity entity = mapper.toEntity(user);
        UserEntity saved = userRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    @Loggable
    public List<User> findAll() {
        return userRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    @Loggable
    public User findById(Long id) {
        return userRepository.findById(id).map(mapper::toDomain).orElse(null);
    }

    @Override
    @Loggable
    public User update(Long id, User user) {
        UserEntity entity = mapper.toEntity(user);
        entity.setId(id);
        UserEntity saved = userRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    @Loggable
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
