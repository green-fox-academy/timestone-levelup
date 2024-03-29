package com.greenfoxacademy.levelup.model;

import java.security.Timestamp;
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
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Pitch {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private boolean status;
  @NonNull
  private int pitchedLevel;
  @NonNull
  private String pitchedMessage;
  private Timestamp created;
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "pitch")
  private Set<Review> reviewSet;
  @ManyToOne
  private BadgeLevel badgeLevel;
  @ManyToOne
  private User user;
}

