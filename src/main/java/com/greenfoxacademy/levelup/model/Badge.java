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
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
public class Badge {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @NonNull
  private String version;
  @NonNull
  private String name;
  @NonNull
  private String tag;
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "badge")
  private Set<BadgeLevel> badgeLevels;
  @ManyToOne
  private User user;
}
