package netology.ru.diplomarestservice.service;

import netology.ru.diplomarestservice.model.User;
import netology.ru.diplomarestservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void changePassword(Long userId, String newPassword) {
        // Implement logic to change user's password
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}