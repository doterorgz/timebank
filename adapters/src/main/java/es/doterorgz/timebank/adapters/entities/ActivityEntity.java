package es.doterorgz.timebank.adapters.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * JPA entity used to persist Activity data.
 */
@Entity
@Table(name = "activity")
@Data
public class ActivityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private int durationHours;

    private double latitude;

    private double longitude;

    @Column(name = "start_date_time")
    private LocalDateTime startDateTime;
}
