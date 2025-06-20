package es.doterorgz.timebank.repository;

import es.doterorgz.timebank.adapters.entities.ActivityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ActivityRepository extends JpaRepository<ActivityEntity, Long> {
    @Query(value = "SELECT * FROM activity a WHERE earth_distance(ll_to_earth(:lat, :lon), ll_to_earth(a.latitude, a.longitude)) <= :distance", nativeQuery = true)
    List<ActivityEntity> findByLocation(@Param("lat") double latitude, @Param("lon") double longitude, @Param("distance") double distance);

    @Query("SELECT a FROM ActivityEntity a WHERE lower(a.title) LIKE lower(concat('%', :text, '%')) OR lower(a.description) LIKE lower" +
            "(concat('%', :text, '%'))")
    List<ActivityEntity> searchByText(@Param("text") String text);

    @Query("SELECT a FROM ActivityEntity a WHERE a.startDateTime BETWEEN :start AND :end")
    List<ActivityEntity> findByDateRange(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);

    @Query(value = "SELECT * FROM activity a WHERE earth_distance(ll_to_earth(:lat, :lon), ll_to_earth(a.latitude, a.longitude)) <= :distance AND (lower(a.title) LIKE lower(concat('%', :text, '%')) OR lower(a.description) LIKE lower(concat('%', :text, '%'))) AND a.start_date_time BETWEEN :start AND :end", nativeQuery = true)
    List<ActivityEntity> search(@Param("lat") double latitude, @Param("lon") double longitude, @Param("distance") double distance,
                          @Param("text") String text, @Param("start") LocalDateTime start, @Param("end") LocalDateTime end);
}
