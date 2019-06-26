package com.greenfoxacademy.levelup.model;

public class MockObject {

  private Double version;
  private String name;
  private String tag;
  private int[] levels;

  public MockObject(Double version, String name, String tag, int[] levels) {
    this.version = version;
    this.name = name;
    this.tag = tag;
    this.levels = levels;
  }

  public MockObject(){
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


