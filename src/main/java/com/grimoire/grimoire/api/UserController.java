package com.grimoire.grimoire.api;

import com.grimoire.grimoire.service.UserService;
import com.grimoire.grimoire.model.User;
import java.util.List;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/user")
@RestController
public class UserController {

  private final UserService userService;

  // ====================================== //
  // CONSTRUCTOR
  // ====================================== //
  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  // ====================================== //
  // HTTP REQUESTS
  // ====================================== //
  @PostMapping // POST request
  public void addUser(@Valid @NonNull @RequestBody User user) {
    userService.addUser(user);
  }

  @GetMapping
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }

  @GetMapping(path = "{id}")
  public User getUserById(@PathVariable("id") UUID id) {
    return userService.getUserById(id)
        .orElse(null);
  }

  @DeleteMapping(path = "{id}")
  public void deleteUserById(@PathVariable("id") UUID id) {
    userService.deleteUser(id);
  }

  @PutMapping(path = "{id}")
  public void updateUser(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody User userToUpdate) {
    userService.updateUser(id, userToUpdate);
  }
}
