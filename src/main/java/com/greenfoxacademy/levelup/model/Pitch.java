package com.greenfoxacademy.levelup.model;

import lombok.*;

import javax.persistence.*;
import java.security.Timestamp;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Pitch {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private boolean status;
  private int pitchedLevel;
  private String pitchedMessage;
  private Timestamp created;
  private List<String> holders;
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "pitch")
  private Set<Review> reviewSet;
  @ManyToOne
  private BadgeLevel badgeLevel;
  @ManyToOne
  private User user;

  public Pitch() {
  }

  /*public Pitch(String badgeName, int oldLVL, int pitchedLVL, String pitchMessage,
      List<String> holders) {
    this.badgeName = badgeName;
    this.oldLVL = oldLVL;
    this.pitchedLVL = pitchedLVL;
    this.pitchMessage = pitchMessage;
    this.holders = holders;
  }*/
}
