package es.doterorgz.timebank.adapter.rest;

import es.doterorgz.timebank.dto.UserDto;
import es.doterorgz.timebank.mapper.UserMapper;
import es.doterorgz.timebank.usecase.CreateUserUseCase;
import es.doterorgz.timebank.usecase.FindAllUsersUseCase;
import es.doterorgz.timebank.usecase.FindUserByIdUseCase;
import es.doterorgz.timebank.usecase.UpdateUserUseCase;
import es.doterorgz.timebank.usecase.DeleteUserUseCase;
import es.doterorgz.timebank.logging.Loggable;
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
    private final FindUserByIdUseCase findUserByIdUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;
    private final UserMapper mapper;

    @PostMapping
    @Loggable
    public ResponseEntity<UserDto> create(@RequestBody UserDto dto) {
        var user = mapper.toEntity(dto);
        var saved = createUserUseCase.execute(user);
        return ResponseEntity.ok(mapper.toDto(saved));
    }

    @GetMapping
    @Loggable
    public ResponseEntity<List<UserDto>> findAll() {
        return ResponseEntity.ok(findAllUsersUseCase.execute().stream().map(mapper::toDto).toList());
    }

    @GetMapping("/{id}")
    @Loggable
    public ResponseEntity<UserDto> findById(@PathVariable Long id) {
        var user = findUserByIdUseCase.execute(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(mapper.toDto(user));
    }

    @PutMapping("/{id}")
    @Loggable
    public ResponseEntity<UserDto> update(@PathVariable Long id, @RequestBody UserDto dto) {
        var user = mapper.toEntity(dto);
        var updated = updateUserUseCase.execute(id, user);
        return ResponseEntity.ok(mapper.toDto(updated));
    }

    @DeleteMapping("/{id}")
    @Loggable
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deleteUserUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
