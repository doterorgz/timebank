package es.doterorgz.timebank.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Activity {
    private Long id;

    private String title;

    private String description;

    private int durationHours;

    private double latitude;

    private double longitude;

    private LocalDateTime startDateTime;

}
