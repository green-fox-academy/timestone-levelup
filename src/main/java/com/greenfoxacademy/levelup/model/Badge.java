package com.greenfoxacademy.levelup.model;
import java.util.List;

public class Badge {
  private long id;
  private String version;
  private String name;
  private String tag;
  private List<BadgeLevel> levels;

  public Badge(long id, String version, String name, String tag, List<BadgeLevel> levels) {
    this.id = id;
    this.version = version;
    this.name = name;
    this.tag = tag;
    this.levels = levels;
  }

  public Badge(String version, String name, String tag, List<BadgeLevel> levels) {
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

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
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

  public List<BadgeLevel> getLevels() {
    return levels;
  }

  public void setLevels(List<BadgeLevel> levels) {
    this.levels = levels;
  }
}
