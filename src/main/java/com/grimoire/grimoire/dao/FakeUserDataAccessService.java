package com.grimoire.grimoire.dao;

import com.grimoire.grimoire.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository("fakeDao") // Class is served as a repository, this allows multiple implementations
public class FakeUserDataAccessService implements UserDao {

  private static List<User> DB = new ArrayList<>();

  @Override
  public int insertUser(UUID id, User user) {
    DB.add(new User(id, user.getUsername(), user.getEmail(), user.getPassword()));
    return 1;
  }

  @Override
  public List<User> selectAllUsers() {
    return DB;
  }

  @Override
  public Optional<User> selectUserById(UUID id) {
    return DB.stream()
        .filter(user -> user.getId().equals(id))
        .findFirst();
  }

  @Override
  public int deleteUserById(UUID id) {
    Optional<User> userOptional = selectUserById(id);
    if (userOptional.isEmpty()) {
      return 0;
    }
    DB.remove(userOptional.get());
    return 1;
  }

  @Override
  public int updateUserById(UUID id, User update) {
    return selectUserById(id)
        .map(user -> {
          int indexOfUserToUpdate = DB.indexOf(user);
          if (indexOfUserToUpdate >= 0) {
            // Troubleshooting REQUIRED!!!
            // *!*!* THIS WILL OVERWRITE VALUES TO NULL IF THEY ARE NOT EXPLICITLY DECLARED IN THE REQUEST BODY *!*!*
            DB.set(indexOfUserToUpdate, new User(id, update.getUsername(), update.getEmail(), update.getPassword()));
            return 1;
          }
          return 0;
        })
        .orElse(0);
  }
}
