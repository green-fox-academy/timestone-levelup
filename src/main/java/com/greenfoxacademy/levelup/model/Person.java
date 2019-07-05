package com.greenfoxacademy.levelup.model;
import java.util.List;

public class Person {
  private long id;
  private String name;
  private String token;
  private String pic;
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
}
