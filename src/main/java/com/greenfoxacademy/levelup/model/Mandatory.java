package com.greenfoxacademy.levelup.model;

import java.lang.reflect.Field;

public class Mandatory {

  private String pitcherName;
  private String badgeName;
  private String newStatus;
  private String newMessage;

  public boolean hasNullField() throws IllegalAccessException {
    for (Field field: this.getClass().getDeclaredFields()) {
      field.setAccessible(true);
      if (field.get(this) == null) {
        return true;
      }
    }
    return false;
  }

  public Mandatory() {
  }

  public Mandatory(String pitcherName, String badgeName, String newStatus,
      String newMessage) {
    this.pitcherName = pitcherName;
    this.badgeName = badgeName;
    this.newStatus = newStatus;
    this.newMessage = newMessage;
  }

  public void setPitcherName(String pitcherName) {
    this.pitcherName = pitcherName;
  }

  public void setBadgeName(String badgeName) {
    this.badgeName = badgeName;
  }

  public void setNewStatus(String newStatus) {
    this.newStatus = newStatus;
  }

  public void setNewMessage(String newMessage) {
    this.newMessage = newMessage;
  }
}