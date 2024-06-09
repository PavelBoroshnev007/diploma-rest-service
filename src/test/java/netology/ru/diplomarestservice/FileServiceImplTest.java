package netology.ru.diplomarestservice.service;

import netology.ru.diplomarestservice.model.File;
import netology.ru.diplomarestservice.repository.FileRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FileServiceImplTest {

    @Mock
    private FileRepository fileRepository;

    @InjectMocks
    private FileServiceImpl fileService;

    private File testFile;

    @BeforeEach
    void setUp() {
        testFile = new File();
        testFile.setId(1L);
        testFile.setFileName("testFile.txt");
        testFile.setFileType("text/plain");
        testFile.setData(new byte[]{1, 2, 3});
    }

    @Test
    void getAllFiles_ReturnsListOfFiles() {
        List<File> files = new ArrayList<>();
        files.add(testFile);

        when(fileRepository.findAll()).thenReturn(files);

        List<File> result = fileService.getAllFiles();

        assertEquals(files.size(), result.size());
        assertEquals(testFile.getFileName(), result.get(0).getFileName());
        assertEquals(testFile.getFileType(), result.get(0).getFileType());
        assertEquals(testFile.getData(), result.get(0).getData());
    }

    @Test
    void getFileById_ReturnsFile_WhenFileExists() {
        when(fileRepository.findById(1L)).thenReturn(Optional.of(testFile));

        Optional<File> result = fileService.getFileById(1L);

        assertEquals(testFile.getFileName(), result.get().getFileName());
        assertEquals(testFile.getFileType(), result.get().getFileType());
        assertEquals(testFile.getData(), result.get().getData());
    }

    @Test
    void getFileById_ReturnsEmptyOptional_WhenFileDoesNotExist() {
        when(fileRepository.findById(2L)).thenReturn(Optional.empty());

        Optional<File> result = fileService.getFileById(2L);

        assertEquals(Optional.empty(), result);
    }

    @Test
    void uploadFile_SavesFile() {
        fileService.uploadFile(testFile);

        verify(fileRepository, times(1)).save(testFile);
    }

    @Test
    void deleteFile_DeletesFile() {
        fileService.deleteFile(1L);

        verify(fileRepository, times(1)).deleteById(1L);
    }
}
