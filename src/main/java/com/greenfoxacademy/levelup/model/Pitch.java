package com.greenfoxacademy.levelup.model;

import java.security.Timestamp;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
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
  @OneToOne
  @MapsId
  private Review review;
  @ManyToOne
  private BadgeLevel badgeLevel;
  @ManyToOne
  private Person person;
}