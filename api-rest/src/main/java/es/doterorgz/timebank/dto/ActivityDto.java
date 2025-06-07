package es.doterorgz.timebank.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ActivityDto {
    private Long id;
    private String title;
    private String description;
    private int durationHours;
    private double latitude;
    private double longitude;
    private LocalDateTime startDateTime;
}
