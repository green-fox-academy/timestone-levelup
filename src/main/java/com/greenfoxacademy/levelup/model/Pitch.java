package com.greenfoxacademy.levelup.model;

import lombok.*;

import javax.persistence.*;
import java.security.Timestamp;
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
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "pitch")
  private Set<Review> reviewSet;
  @ManyToOne
  private BadgeLevel badgeLevel;
  @ManyToOne
  private User user;
}

