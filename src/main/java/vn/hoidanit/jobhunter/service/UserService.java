package vn.hoidanit.jobhunter.service;

// import org.hibernate.mapping.List;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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

    // Get all users
    public List<User> handleGetAllUser() {
        return this.userRepository.findAll();

    }

    // Get user by id
    public User handleGetUserById(Long id) {
        return this.userRepository.findById(id).orElse(null);
    }

    // Update User by id
    public User handleUpdateUserById(Long id, User user) {
        User userUpdate = this.handleGetUserById(user.getId());
        if (userUpdate != null) {
            userUpdate.setName(user.getName());
            userUpdate.setEmail(user.getEmail());
            userUpdate.setPassword(user.getPassword());
            // System.out.println(this.userRepository.save(userUpdate).getClass().getSimpleName());
            return this.userRepository.save(userUpdate);

        }
        return null;
    }
}
