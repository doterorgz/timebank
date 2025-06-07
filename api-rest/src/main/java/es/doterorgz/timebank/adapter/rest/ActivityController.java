package es.doterorgz.timebank.adapter.rest;

import es.doterorgz.timebank.dto.ActivityDto;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activities")
@RequiredArgsConstructor
public class ActivityController {
    private final ActivityService activityService;
    private final ActivityMapper mapper;

    @PostMapping
    public ResponseEntity<ActivityDto> create(@RequestBody ActivityDto dto) {
        var activity = mapper.toEntity(dto);
        var saved = activityService.create(activity);
        return ResponseEntity.ok(mapper.toDto(saved));
    }

    @GetMapping
    public ResponseEntity<List<ActivityDto>> findAll() {
        return ResponseEntity.ok(activityService.findAll().stream().map(mapper::toDto).toList());
    }

    @GetMapping("/location")
    public ResponseEntity<List<ActivityDto>> byLocation(@RequestParam double lat,
                                                        @RequestParam double lon,
                                                        @RequestParam double distance) {
        return ResponseEntity.ok(activityService.findByLocation(lat, lon, distance)
                .stream().map(mapper::toDto).toList());
    }

    @GetMapping("/search")
    public ResponseEntity<List<ActivityDto>> byText(@RequestParam String text) {
        return ResponseEntity.ok(activityService.searchByText(text).stream().map(mapper::toDto).toList());
    }

    @GetMapping("/dates")
    public ResponseEntity<List<ActivityDto>> byDateRange(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) java.time.LocalDateTime start,
                                                         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) java.time.LocalDateTime end) {
        return ResponseEntity.ok(activityService.findByDateRange(start, end).stream().map(mapper::toDto).toList());
    }

    @GetMapping("/filter")
    public ResponseEntity<List<ActivityDto>> search(@RequestParam double lat,
                                                    @RequestParam double lon,
                                                    @RequestParam double distance,
                                                    @RequestParam String text,
                                                    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) java.time.LocalDateTime start,
                                                    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) java.time.LocalDateTime end) {
        return ResponseEntity.ok(activityService.search(lat, lon, distance, text, start, end)
                .stream().map(mapper::toDto).toList());
    }
}
