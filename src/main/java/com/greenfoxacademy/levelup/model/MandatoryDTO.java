package com.greenfoxacademy.levelup.model;

public class MandatoryDTO {
  private String pitcherName;
  private String badgeName;
  private String newStatus;
  private String newMessage;

  public MandatoryDTO(Mandatory mandatory) {
    this.pitcherName = mandatory.getPitcherName();
    this.badgeName = mandatory.getBadgeName();
    this.newStatus = mandatory.getNewStatus();
    this.newMessage = mandatory.getNewMessage();
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
