package com.grimoire.grimoire.dao;

import com.grimoire.grimoire.model.User;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository("postgres") // This service is for the actual postgres database
public class UserDataAccessService implements UserDao {

  @Override
  public int insertUser(UUID id, User user) {
    return 0;
  }

  @Override
  public List<User> selectAllUsers() {
    return List.of(new User(UUID.randomUUID(), "From PSQL DB", "psql@postgres.com", "password1"));
  }

  @Override
  public Optional<User> selectUserById(UUID id) {
    return Optional.empty();
  }

  @Override
  public int deleteUserById(UUID id) {
    return 0;
  }

  @Override
  public int updateUserById(UUID id, User user) {
    return 0;
  }
}
