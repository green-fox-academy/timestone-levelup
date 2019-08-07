package com.greenfoxacademy.levelup.service;

import com.greenfoxacademy.levelup.collection.Message;
import com.greenfoxacademy.levelup.model.Badge;
import com.greenfoxacademy.levelup.repository.IBadgeRepository;
import com.greenfoxacademy.levelup.utility.Util;
import java.util.ArrayList;
import java.util.List;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@Service
public class BadgeServiceImp implements IBadgeService {

  @Autowired
  private IBadgeRepository badgeRepository;

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
    return new ResponseEntity<>(Util.convertModelToJson(this.findById(id)),
        HttpStatus.OK);
  }

  public ResponseEntity<String> getBadgesJsonObjects(String authorization) {
    if (authorization == null || !authorization.equals(Message.AUTHORIZATION_OK)) {
      return new ResponseEntity<>(Message.UNAUTHORIZED_BODY,
          HttpStatus.UNAUTHORIZED);
    }
    return new ResponseEntity<>(Util.convertListOfBadgeToJson(findAll()),
        HttpStatus.OK);
  }
}
