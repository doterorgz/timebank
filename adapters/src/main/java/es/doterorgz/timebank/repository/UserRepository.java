package es.doterorgz.timebank.repository;

import es.doterorgz.timebank.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
