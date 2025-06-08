package es.doterorgz.timebank.adapter.rest;

import es.doterorgz.timebank.dto.UserDto;
import es.doterorgz.timebank.mapper.UserMapper;
import es.doterorgz.timebank.usecase.CreateUserUseCase;
import es.doterorgz.timebank.usecase.FindAllUsersUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final CreateUserUseCase createUserUseCase;
    private final FindAllUsersUseCase findAllUsersUseCase;
    private final UserMapper mapper;

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody UserDto dto) {
        var user = mapper.toEntity(dto);
        var saved = createUserUseCase.execute(user);
        return ResponseEntity.ok(mapper.toDto(saved));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll() {
        return ResponseEntity.ok(findAllUsersUseCase.execute().stream().map(mapper::toDto).toList());
    }
}
