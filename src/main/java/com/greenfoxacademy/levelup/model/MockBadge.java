package com.greenfoxacademy.levelup.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MockBadge {

  private String version;
  private String name;
  private String tag;
  private int[] levels;
}
