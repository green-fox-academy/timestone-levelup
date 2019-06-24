package com.greenfoxacademy.levelup.model;

public class MockObjectDTO {

  private double version;
  private String name;
  private String tag;
  private int[] level;

  public MockObjectDTO(MockObject object) {
    this.version = object.getVersion();
    this.name = object.getName();
    this.tag = object.getTag();
    this.level = object.getLevel();
  }

  public MockObjectDTO() {
  }

  public double getVersion() {
    return version;
  }

  public void setVersion(double version) {
    this.version = version;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }

  public int[] getLevel() {
    return level;
  }

  public void setLevel(int[] level) {
    this.level = level;
  }
}
