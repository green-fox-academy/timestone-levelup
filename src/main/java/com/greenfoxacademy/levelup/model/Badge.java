package com.greenfoxacademy.levelup.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Badge {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String version;
  private String name;
  private String tag;
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "badge")
  private List<BadgeLevel> levels;
  @ManyToOne
  private Person person;

  public Badge() {
  }

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

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }
}
