package es.doterorgz.timebank.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Activity {
    private Long id;

    private String title;

    private String description;

    private int durationHours;

    private double latitude;

    private double longitude;

    private LocalDateTime startDateTime;

}
