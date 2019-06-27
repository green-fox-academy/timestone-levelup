package com.greenfoxacademy.levelup.model;

import java.util.ArrayList;
import java.util.List;

public class BadgeDTO {
  List<Badge> badges;

  public BadgeDTO(){
    badges = new ArrayList<>();
    badges.add(new Badge("Process improver", "2"));
    badges.add(new Badge("English speaker", "1"));
    badges.add(new Badge("Feedback giver", "1"));
  }

  public List<Badge> getBadges() {
    return badges;
  }

  public void setBadges(List<Badge> badges) {
    this.badges = badges;
  }
}