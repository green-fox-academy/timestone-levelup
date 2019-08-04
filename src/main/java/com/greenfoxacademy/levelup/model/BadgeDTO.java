package com.greenfoxacademy.levelup.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MockBadgeDTO {

  private long id;
  private String version;
  private String name;
  private String tag;
  private int[] levels;

  public MockBadgeDTO(MockBadge mockBadge) {
    this.version = mockBadge.getVersion();
    this.name = mockBadge.getName();
    this.tag = mockBadge.getTag();
    this.levels = mockBadge.getLevels();
  }

  public MockBadgeDTO() {
  }

}
