package com.greenfoxacademy.levelup.model;

import java.util.List;

public class Badge {
  private long id;
  private Double version;
  private String name;
  private String tag;
  private List<Level> levels;

  public Badge(long id, Double version, String name, String tag, List<Level> levels) {
    this.id = id;
    this.version = version;
    this.name = name;
    this.tag = tag;
    this.levels = levels;
  }

  public Badge() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
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

  public List<Level> getLevels() {
    return levels;
  }

  public void setLevels(List<Level> levels) {
    this.levels = levels;
  }
}
