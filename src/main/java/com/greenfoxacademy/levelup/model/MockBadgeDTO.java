package com.greenfoxacademy.levelup.model;

public class MockBadgeDTO {

  private Double version;
  private String name;
  private String tag;
  private int[] levels;

  public MockBadgeDTO(MockBadge mockBadge) {
    this.version = mockBadge.getVersion();
    this.name = mockBadge.getName();
    this.tag = mockBadge.getTag();
    this.levels = mockBadge.getLevels();
  }

  public MockBadgeDTO() {
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
