package com.greenfoxacademy.levelup.model;

import java.lang.reflect.Field;
import java.util.List;

public class Pitch {
  private String badgeName;
  private int oldLVL;
  private int pitchedLVL;
  private String pitchMessage;
  private List<String> holders;

  public Pitch() {
  }

  public Pitch(String badgeName, int oldLVL, int pitchedLVL, String pitchMessage, List<String> holders) {
    this.badgeName = badgeName;
    this.oldLVL = oldLVL;
    this.pitchedLVL = pitchedLVL;
    this.pitchMessage = pitchMessage;
    this.holders = holders;
  }

  public String getBadgeName() {
    return badgeName;
  }

  public void setBadgeName(String badgeName) {
    this.badgeName = badgeName;
  }

  public int getOldLVL() {
    return oldLVL;
  }

  public void setOldLVL(int oldLVL) {
    this.oldLVL = oldLVL;
  }

  public int getPitchedLVL() {
    return pitchedLVL;
  }

  public void setPitchedLVL(int pitchedLVL) {
    this.pitchedLVL = pitchedLVL;
  }

  public String getPitchMessage() {
    return pitchMessage;
  }

  public void setPitchMessage(String pitchMessage) {
    this.pitchMessage = pitchMessage;
  }

  public List<String> getHolders() {
    return holders;
  }

  public void setHolders(List<String> holders) {
    this.holders = holders;
  }

  public boolean hasNullField() throws IllegalAccessException {
    for (Field field : this.getClass().getDeclaredFields()) {
      if (field.get(this) == null) {
        return true;
      }
    }
    return false;
  }
}