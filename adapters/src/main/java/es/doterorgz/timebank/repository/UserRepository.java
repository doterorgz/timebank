package es.doterorgz.timebank.repository;

import es.doterorgz.timebank.adapters.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
