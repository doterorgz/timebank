package es.doterorgz.timebank.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.ManyToMany;
import java.time.LocalDateTime;
import java.util.Set;
import lombok.Data;

@Entity
@Data
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private int durationHours;

    private double latitude;

    private double longitude;

    private LocalDateTime startDateTime;

    @ManyToOne
    private User instructor;

    @ManyToMany
    private Set<User> participants;
}
