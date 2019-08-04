package com.greenfoxacademy.levelup.model;

import javax.persistence.*;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
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
  private List<BadgeLevel> levels;
  @ManyToOne
  private Person person;
}
