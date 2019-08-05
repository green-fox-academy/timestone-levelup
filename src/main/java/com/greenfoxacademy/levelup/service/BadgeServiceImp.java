package com.greenfoxacademy.levelup.service;

import com.greenfoxacademy.levelup.model.Badge;
import com.greenfoxacademy.levelup.repository.IBadgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BadgeServiceImp implements IBadgeService{

  @Autowired
  private IBadgeRepository badgeRepository;

  @Override
  public void save(Badge badge) {
    badgeRepository.save(badge);
  }

  @Override
  public void delete(long id) {
    badgeRepository.delete(badgeRepository.findById(id).get());
  }

  @Override
  public List<Badge> findAll() {
    List<Badge> badges = new ArrayList<>();
    badgeRepository.findAll().forEach(badge -> badges.add(badge));
    return badges;
  }

  @Override
  public Badge findById(long id) {
    return badgeRepository.findById(id).get();
  }
}
