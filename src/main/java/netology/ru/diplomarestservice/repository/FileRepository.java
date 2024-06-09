package netology.ru.diplomarestservice.repository;

import netology.ru.diplomarestservice.model.File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileRepository extends JpaRepository<File, Long> {
    List<File> findByUserId(Long userId);
    File findByUserIdAndFileName(Long userId, String fileName);
}