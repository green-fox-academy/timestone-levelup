package com.greenfoxacademy.levelup.model;

public class MockObjectDTO {

  private Double version;
  private String name;
  private String tag;
  private int[] levels;

  public MockObjectDTO(MockObject object) {
    this.version = object.getVersion();
    this.name = object.getName();
    this.tag = object.getTag();
    this.levels = object.getLevels();
  }

  public MockObjectDTO() {
  }

  public Double getVersion() {
    return version;
  }

  public void setVersion(Double version) {
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

  public int[] getLevels() {
    return levels;
  }

  public void setLevels(int[] levels) {
    this.levels = levels;
  }
}