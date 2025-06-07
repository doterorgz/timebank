package es.doterorgz.timebank.repository;

import es.doterorgz.timebank.domain.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
