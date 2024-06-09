package netology.ru.diplomarestservice.repository;

import netology.ru.diplomarestservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
