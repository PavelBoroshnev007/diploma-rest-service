package netology.ru.diplomarestservice.service;

import netology.ru.diplomarestservice.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(Long userId);
    void createUser(User user);
    void changePassword(Long userId, String newPassword);
    void deleteUser(Long userId);
}