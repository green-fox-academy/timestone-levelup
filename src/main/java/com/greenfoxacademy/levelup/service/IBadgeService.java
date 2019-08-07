package com.greenfoxacademy.levelup.service;

import com.greenfoxacademy.levelup.model.Badge;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface IBadgeService {
  void save(Badge badge);
  void delete(long id);
  List<Badge> findAll();
  Badge findById(long id);
  ResponseEntity<String> getBadgeJsonById(long id, String authorization);
  ResponseEntity<String> getBadgesJsonObjects(String authorization);
  ResponseEntity<String> getAuthorizationAndStatusCreated(String authorization, Object object);
}
