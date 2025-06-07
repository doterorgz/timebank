package es.doterorgz.timebank.adapter.rest;

import es.doterorgz.timebank.dto.ActivityDto;
import es.doterorgz.timebank.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activities")
@RequiredArgsConstructor
public class ActivityController {
    private final ActivityService activityService;

    @PostMapping
    public ResponseEntity<ActivityDto> create(@RequestBody ActivityDto dto) {
        return ResponseEntity.ok(activityService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<ActivityDto>> findAll() {
        return ResponseEntity.ok(activityService.findAll());
    }
}
