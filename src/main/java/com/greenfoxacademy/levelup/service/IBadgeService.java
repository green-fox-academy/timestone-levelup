package com.greenfoxacademy.levelup.service;

import com.greenfoxacademy.levelup.model.Badge;
import java.util.List;

public interface IBadgeService {
  void save(Badge badge);
  void delete(long id);
  List<Badge> findAll();
  Badge findById(long id);
}
