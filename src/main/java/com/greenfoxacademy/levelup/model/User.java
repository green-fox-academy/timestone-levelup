package com.greenfoxacademy.levelup.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String name;
  private String email;
  private String role;
  @ManyToOne
  private BadgeLevel badgeLevel;
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
  //@MapsId
  private Set<Review> review;
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
  //@MapsId
  private Set<Pitch> pitch;
}
