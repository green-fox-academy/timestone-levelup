package com.greenfoxacademy.levelup.model;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

public class BadgeLevel {
  private long id;
  private int level;
  private int weight;
  private String description;
  @ManyToOne
  private Badge badge;
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "badgeLevel")
  private List<Person> holders;

  public BadgeLevel() {
  }

  public BadgeLevel(long id, int level, int weight, String description, List<Person> holders) {
    this.id = id;
    this.level = level;
    this.weight = weight;
    this.description = description;
    this.holders = holders;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<Person> getHolders() {
    return holders;
  }

  public void setHolders(List<Person> holders) {
    this.holders = holders;
  }

  public Badge getBadge() {
    return badge;
  }

  public void setBadge(Badge badge) {
    this.badge = badge;
  }
}
