package com.grimoire.grimoire.service;

import com.grimoire.grimoire.dao.UserDao;
import com.grimoire.grimoire.model.User;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;

@Service // Class will be served as a service
public class UserService {

  // This is the actual interface, not the specific class
  private final UserDao userDao;

  // ====================================== //
  // CONSTRUCTOR
  // ====================================== //
  @Autowired
  public UserService(@Qualifier("postgres") UserDao userDao) {
    this.userDao = userDao;
  }

  public int addUser(User user) {
    return userDao.insertUser(user);
  }

  public List<User> getAllUsers() {
    return userDao.selectAllUsers();
  }

  public Optional<User> getUserById(UUID id) {
    return userDao.selectUserById(id);
  }

  public int deleteUser(UUID id) {
    return userDao.deleteUserById(id);
  }

  public int updateUser(UUID id, User newUser) {
    return userDao.updateUserById(id, newUser);
  }
}
