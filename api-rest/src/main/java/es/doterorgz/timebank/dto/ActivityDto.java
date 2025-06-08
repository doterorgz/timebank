package es.doterorgz.timebank.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActivityDto {
    private Long id;
    private String title;
    private String description;
    private int durationHours;
    private double latitude;
    private double longitude;
    private LocalDateTime startDateTime;
}
