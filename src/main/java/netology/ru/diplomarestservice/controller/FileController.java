package netology.ru.diplomarestservice.controller;

import netology.ru.diplomarestservice.model.File;
import netology.ru.diplomarestservice.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/files")
public class FileController {

    private final FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping
    public List<File> getAllFiles() {
        return fileService.getAllFiles();
    }

    @GetMapping("/{fileId}")
    public Optional<File> getFileById(@PathVariable Long fileId) {
        return fileService.getFileById(fileId);
    }

    @PostMapping
    public void uploadFile(@RequestBody File file) {
        fileService.uploadFile(file);
    }

    @DeleteMapping("/{fileId}")
    public void deleteFile(@PathVariable Long fileId) {
        fileService.deleteFile(fileId);
    }
}