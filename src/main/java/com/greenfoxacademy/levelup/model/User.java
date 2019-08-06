package com.greenfoxacademy.levelup.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
  private Set<Review> review;
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
  private Set<Pitch> pitch;
}
