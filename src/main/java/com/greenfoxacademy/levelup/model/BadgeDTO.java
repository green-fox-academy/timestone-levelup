package com.greenfoxacademy.levelup.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class BadgeDTO {

  private long id;
  @NonNull
  private String version;
  @NonNull
  private String name;
  @NonNull
  private String tag;
  private int[] levels;
}
