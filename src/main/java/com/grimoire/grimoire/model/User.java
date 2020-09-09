package com.grimoire.grimoire.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;
import javax.validation.constraints.NotBlank;

public class User {

  // ====================================== //
  // INSTANCE VARIABLES
  // ====================================== //
  private final UUID id;
  @NotBlank
  private final String username;
  @NotBlank
  private final String email;
  @NotBlank
  private final String password;

  // ====================================== //
  // CONSTRUCTOR
  // ====================================== //
  public User(@JsonProperty("id") UUID id,
      @JsonProperty("username") String username,
      @JsonProperty("email") String email,
      @JsonProperty("password") String password) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.password = password;
  }

  // ====================================== //
  // GETTERS
  // ====================================== //
  public UUID getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }
}
