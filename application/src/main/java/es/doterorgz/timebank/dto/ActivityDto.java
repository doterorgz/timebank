package es.doterorgz.timebank.dto;

import lombok.Data;
import java.util.Set;

@Data
public class ActivityDto {
    private Long id;
    private String title;
    private String description;
    private int durationHours;
    private Long instructorId;
    private Set<Long> participantIds;
}
