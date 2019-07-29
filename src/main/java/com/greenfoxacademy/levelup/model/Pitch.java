package com.greenfoxacademy.levelup.model;

import java.security.Timestamp;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

  public Pitch(String badgeName, int oldLVL, int pitchedLVL, String pitchMessage,
      List<String> holders) {
    this.badgeName = badgeName;
    this.oldLVL = oldLVL;
    this.pitchedLVL = pitchedLVL;
    this.pitchMessage = pitchMessage;
    this.holders = holders;
  }
}
