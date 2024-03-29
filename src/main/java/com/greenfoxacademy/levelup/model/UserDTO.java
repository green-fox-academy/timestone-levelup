package com.greenfoxacademy.levelup.model;

public class UserDTO {
  private long id;
  private String name;

  public UserDTO(){
  }

  public UserDTO(User user) {
    this.id = user.getId();
    this.name = user.getName();
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
