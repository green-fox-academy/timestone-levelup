package com.greenfoxacademy.levelup.service;

import com.google.gson.Gson;
import com.greenfoxacademy.levelup.collection.Message;
import com.greenfoxacademy.levelup.model.Badge;
import com.greenfoxacademy.levelup.repository.IBadgeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BadgeServiceImp implements IBadgeService{

  private final IBadgeRepository badgeRepository;

  public BadgeServiceImp(IBadgeRepository badgeRepository) {
    this.badgeRepository = badgeRepository;
  }

  @Override
  public void save(Badge badge) {
    badgeRepository.save(badge);
  }

  @Override
  public void delete(long id) {
    badgeRepository.delete(badgeRepository.findById(id).orElse(null));
  }

  @Override
  public List<Badge> findAll() {
    List<Badge> badges = new ArrayList<>();
    badgeRepository.findAll().forEach(badges::add);
    return badges;
  }

  @Override
  public Badge findById(long id) {
    return badgeRepository.findById(id).orElse(null);
  }

  @Override
  public ResponseEntity<String> getBadgeJsonById(long id, String authorization) {
    if (authorization == null || !authorization.equals(Message.AUTHORIZATION_OK)) {
      return new ResponseEntity<>(Message.UNAUTHORIZED_BODY,
          HttpStatus.UNAUTHORIZED);
    }
    return new ResponseEntity<>(convertModel2Json(this.findById(id)),
        HttpStatus.OK);
  }

  private String convertModel2Json(Object object) {
    Gson gson = new Gson();
    return gson.toJson(object);
  }
}
