package netology.ru.diplomarestservice.service;

import netology.ru.diplomarestservice.model.File;
import netology.ru.diplomarestservice.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FileServiceImpl implements FileService {

    private final FileRepository fileRepository;

    @Autowired
    public FileServiceImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    public List<File> getAllFiles() {
        return fileRepository.findAll();
    }

    @Override
    public Optional<File> getFileById(Long fileId) {
        return fileRepository.findById(fileId);
    }

    @Override
    public void uploadFile(File file) {
        fileRepository.save(file);
    }

    @Override
    public void deleteFile(Long fileId) {
        fileRepository.deleteById(fileId);
    }
}