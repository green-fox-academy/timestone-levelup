package com.greenfoxacademy.levelup.service;

import com.greenfoxacademy.levelup.model.BadgeLevel;
import com.greenfoxacademy.levelup.repository.IBadgeLevelRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BadgeLevelServiceImp implements IBadgeLevelService {

  public final IBadgeLevelRepository badgeLevelRepository;

  public BadgeLevelServiceImp(IBadgeLevelRepository badgeLevelRepository) {
    this.badgeLevelRepository = badgeLevelRepository;
  }

  @Override
  public void save(BadgeLevel badgeLevel) {
    badgeLevelRepository.save(badgeLevel);
  }

  @Override
  public void delete(long id) {
    badgeLevelRepository.delete(badgeLevelRepository.findById(id).get());
  }

  @Override
  public List<BadgeLevel> findAll() {
    List<BadgeLevel> badgeLevels = new ArrayList<>();
    badgeLevelRepository.findAll().forEach(badgeLevel -> badgeLevels.add(badgeLevel));
    return badgeLevels;
  }

  @Override
  public BadgeLevel findById(long id) {
    return badgeLevelRepository.findById(id).get();
  }
}
