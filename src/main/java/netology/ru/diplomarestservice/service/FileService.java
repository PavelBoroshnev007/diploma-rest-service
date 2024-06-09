package netology.ru.diplomarestservice.service;

import netology.ru.diplomarestservice.model.File;

import java.util.List;
import java.util.Optional;

public interface FileService {
    List<File> getAllFiles();
    Optional<File> getFileById(Long fileId);
    void uploadFile(File file);
    void deleteFile(Long fileId);
}