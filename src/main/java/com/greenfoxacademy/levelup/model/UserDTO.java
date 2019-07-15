package com.greenfoxacademy.levelup.model;

public class PersonDTO {
  private long id;
  private String name;

  public PersonDTO(){
  }

  public PersonDTO(Person person) {
    this.id = person.getId();
    this.name = person.getName();
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
