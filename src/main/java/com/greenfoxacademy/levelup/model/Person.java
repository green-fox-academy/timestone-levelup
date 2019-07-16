package com.greenfoxacademy.levelup.model;
import javax.persistence.*;
import java.util.List;

@Entity
public class Person {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String name;
  private String token;
  private String pic;
  @ManyToOne
  private BadgeLevel badgeLevel;
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
  private List<Badge> badges;

  public Person() {
  }

  public Person(long id, String name, String token, String pic, List<Badge> badges) {
    this.id = id;
    this.name = name;
    this.token = token;
    this.pic = pic;
    this.badges = badges;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getPic() {
    return pic;
  }

  public void setPic(String pic) {
    this.pic = pic;
  }

  public List<Badge> getBadges() {
    return badges;
  }

  public void setBadges(List<Badge> badges) {
    this.badges = badges;
  }

  public BadgeLevel getBadgeLevel() {
    return badgeLevel;
  }

  public void setBadgeLevel(BadgeLevel badgeLevel) {
    this.badgeLevel = badgeLevel;
  }
}
