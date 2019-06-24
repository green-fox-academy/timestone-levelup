package com.greenfoxacademy.levelup.model;

public class MockObject {

  private double version;
  private String name;
  private String tag;
  private int[] level;

  public MockObject(double version, String name, String tag, int[] level) {
    this.version = version;
    this.name = name;
    this.tag = tag;
    this.level = level;
  }

  public MockObject(){
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


