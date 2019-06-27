package com.greenfoxacademy.levelup.model;

public class Badge {
  String name;
  String level;

  public Badge(){
  }

  public Badge(String name, String level) {
    this.name = name;
    this.level = level;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
  }
}