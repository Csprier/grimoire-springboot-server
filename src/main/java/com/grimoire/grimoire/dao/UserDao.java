package com.grimoire.grimoire.dao;
import com.grimoire.grimoire.model.User;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

// ====================================== //
// DAO = Data Access Object
// ====================================== //
public interface UserDao {

  int insertUser(UUID id, User user);

  default int insertUser(User user) {
    UUID id = UUID.randomUUID();
    return insertUser(id, user);
  }

  List<User> selectAllUsers();

  Optional<User> selectUserById(UUID id);

  int deleteUserById(UUID id);

  int updateUserById(UUID id, User user);
}
