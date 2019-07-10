package com.greenfoxacademy.levelup.service;

import com.greenfoxacademy.levelup.model.BadgeLevel;
import java.util.List;

public interface IBadgeLevelService {
  void save(BadgeLevel badgeLevel);
  void delete(long id);
  List<BadgeLevel> findAll();
  BadgeLevel findById(long id);
}
