package vn.hoidanit.jobhunter.service;

import org.springframework.stereotype.Service;

import vn.hoidanit.jobhunter.domain.User;
import vn.hoidanit.jobhunter.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Create a new user
    public User handleCreateUser(User user) {
        return this.userRepository.save(user);
    }

    // Delete a user
    public void handleDeleteUser(Long id) {
        this.userRepository.deleteById(id);
    }
}
