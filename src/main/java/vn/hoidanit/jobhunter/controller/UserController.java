package vn.hoidanit.jobhunter.controller;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
// import org.hibernate.mapping.List;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import vn.hoidanit.jobhunter.domain.User;
import vn.hoidanit.jobhunter.service.UserService;
import vn.hoidanit.jobhunter.service.error.IdInvalidException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // @GetMapping("user/create")
    @PostMapping("/users")
    public ResponseEntity<User> createNewUser(@RequestBody User postNewUser) {
        User newUser = this.userService.handleCreateUser(postNewUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    // Delete a user
    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) throws IdInvalidException {

        if (id >= 1500) {
            throw new IdInvalidException("Id không lớn hơn 1500");
        }

        this.userService.handleDeleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    // Get all users
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> listUser = this.userService.handleGetAllUser();
        return ResponseEntity.status(HttpStatus.OK).body(listUser);
    }

    // Get user by id
    @GetMapping("/users/{user-id}")
    public ResponseEntity<User> getUserById(@PathVariable("user-id") Long id) {
        User userFind = this.userService.handleGetUserById(id);
        // return ResponseEntity.status(HttpStatus.OK).body(userFind);
        return ResponseEntity.ok(userFind); // Cách 2
    }

    // Update User
    @PutMapping("/users/{id}")
    public ResponseEntity<User> putMethodName(@PathVariable("id") Long id,
            @RequestBody User userUpdate) {
        User userUpdated = this.userService.handleUpdateUserById(id, userUpdate);
        return ResponseEntity.status(HttpStatus.OK).body(userUpdated);
    }

}
