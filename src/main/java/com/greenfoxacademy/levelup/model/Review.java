package com.greenfoxacademy.levelup.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Review {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String message;
  private boolean result;
  @OneToOne(fetch = FetchType.LAZY)
  @MapsId
  private User user;
  @OneToOne(fetch = FetchType.LAZY)
  @MapsId
  private Pitch pitch;
}
