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

  public String getPitcherName() {
    return pitcherName;
  }

  public void setPitcherName(String pitcherName) {
    this.pitcherName = pitcherName;
  }

  public String getBadgeName() {
    return badgeName;
  }

  public void setBadgeName(String badgeName) {
    this.badgeName = badgeName;
  }

  public String getNewStatus() {
    return newStatus;
  }

  public void setNewStatus(String newStatus) {
    this.newStatus = newStatus;
  }

  public String getNewMessage() {
    return newMessage;
  }

  public void setNewMessage(String newMessage) {
    this.newMessage = newMessage;
  }
}