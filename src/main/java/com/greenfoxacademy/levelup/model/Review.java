package com.greenfoxacademy.levelup.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Review {

  @Getter
  @Setter
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private boolean messageResult;
  @OneToOne(fetch = FetchType.LAZY)
  @MapsId
  private Person person;

  public Review() {
  }

  public Review(boolean messageResult, Person person) {
    this.messageResult = messageResult;
    this.person = person;
  }
}
