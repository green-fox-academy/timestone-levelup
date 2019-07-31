package com.greenfoxacademy.levelup.model;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BadgeLevel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private int level;
  private int weight;
  private String description;
  @ManyToOne
  private Badge badge;
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "badgeLevel")
  private Set<User> userSet;
}
