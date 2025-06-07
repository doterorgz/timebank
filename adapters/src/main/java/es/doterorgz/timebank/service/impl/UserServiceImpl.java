package es.doterorgz.timebank.service.impl;

import es.doterorgz.timebank.dto.UserDto;
import es.doterorgz.timebank.mapper.UserMapper;
import es.doterorgz.timebank.repository.UserRepository;
import es.doterorgz.timebank.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper mapper;

    @Override
    public UserDto create(UserDto userDto) {
        var user = mapper.toEntity(userDto);
        var saved = userRepository.save(user);
        return mapper.toDto(saved);
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
