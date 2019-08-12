package com.greenfoxacademy.levelup.model;

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
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @NonNull
  private String name;
  @NonNull
  private String email;
  @NonNull
  private String role;
  @ManyToOne
  private BadgeLevel badgeLevel;
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
  private Set<Review> review;
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
  private Set<Pitch> pitch;
}
