package es.doterorgz.timebank.adapter.rest;

import es.doterorgz.timebank.dto.ActivityDto;
import es.doterorgz.timebank.mapper.ActivityMapper;
import es.doterorgz.timebank.usecase.CreateActivityUseCase;
import es.doterorgz.timebank.usecase.FindActivitiesByDateRangeUseCase;
import es.doterorgz.timebank.usecase.FindActivitiesByLocationUseCase;
import es.doterorgz.timebank.usecase.FindAllActivitiesUseCase;
import es.doterorgz.timebank.usecase.SearchActivitiesByTextUseCase;
import es.doterorgz.timebank.usecase.SearchActivitiesUseCase;
import es.doterorgz.timebank.usecase.FindActivityByIdUseCase;
import es.doterorgz.timebank.usecase.UpdateActivityUseCase;
import es.doterorgz.timebank.usecase.DeleteActivityUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activities")
@RequiredArgsConstructor
public class ActivityController {
    private final CreateActivityUseCase createActivityUseCase;
    private final FindAllActivitiesUseCase findAllActivitiesUseCase;
    private final FindActivitiesByLocationUseCase findActivitiesByLocationUseCase;
    private final SearchActivitiesByTextUseCase searchActivitiesByTextUseCase;
    private final FindActivitiesByDateRangeUseCase findActivitiesByDateRangeUseCase;
    private final SearchActivitiesUseCase searchActivitiesUseCase;
    private final FindActivityByIdUseCase findActivityByIdUseCase;
    private final UpdateActivityUseCase updateActivityUseCase;
    private final DeleteActivityUseCase deleteActivityUseCase;
    private final ActivityMapper mapper;

    @PostMapping
    public ResponseEntity<ActivityDto> create(@RequestBody ActivityDto dto) {
        var activity = mapper.toEntity(dto);
        var saved = createActivityUseCase.execute(activity);
        return ResponseEntity.ok(mapper.toDto(saved));
    }

    @GetMapping
    public ResponseEntity<List<ActivityDto>> findAll() {
        return ResponseEntity.ok(findAllActivitiesUseCase.execute().stream().map(mapper::toDto).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActivityDto> findById(@PathVariable Long id) {
        var activity = findActivityByIdUseCase.execute(id);
        if (activity == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(mapper.toDto(activity));
    }

    @GetMapping("/location")
    public ResponseEntity<List<ActivityDto>> byLocation(@RequestParam double lat,
                                                        @RequestParam double lon,
                                                        @RequestParam double distance) {
        return ResponseEntity.ok(findActivitiesByLocationUseCase.execute(lat, lon, distance)
                .stream().map(mapper::toDto).toList());
    }

    @GetMapping("/search")
    public ResponseEntity<List<ActivityDto>> byText(@RequestParam String text) {
        return ResponseEntity.ok(searchActivitiesByTextUseCase.execute(text).stream().map(mapper::toDto).toList());
    }

    @GetMapping("/dates")
    public ResponseEntity<List<ActivityDto>> byDateRange(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) java.time.LocalDateTime start,
                                                         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) java.time.LocalDateTime end) {
        return ResponseEntity.ok(findActivitiesByDateRangeUseCase.execute(start, end).stream().map(mapper::toDto).toList());
    }

    @GetMapping("/filter")
    public ResponseEntity<List<ActivityDto>> search(@RequestParam double lat,
                                                    @RequestParam double lon,
                                                    @RequestParam double distance,
                                                    @RequestParam String text,
                                                    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) java.time.LocalDateTime start,
                                                    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) java.time.LocalDateTime end) {
        return ResponseEntity.ok(searchActivitiesUseCase.execute(lat, lon, distance, text, start, end)
                .stream().map(mapper::toDto).toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActivityDto> update(@PathVariable Long id, @RequestBody ActivityDto dto) {
        var activity = mapper.toEntity(dto);
        var updated = updateActivityUseCase.execute(id, activity);
        return ResponseEntity.ok(mapper.toDto(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deleteActivityUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
