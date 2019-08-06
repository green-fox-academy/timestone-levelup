package com.greenfoxacademy.levelup.service;

import com.google.gson.Gson;
import com.greenfoxacademy.levelup.collection.Message;
import com.greenfoxacademy.levelup.model.Badge;
import com.greenfoxacademy.levelup.repository.IBadgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


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
  public ResponseEntity<String> getBadgesJsonObjects(String authorization) {
    if (authorization == null || !authorization.equals(Message.AUTHORIZATION_OK)) {
      return new ResponseEntity<>(Message.UNAUTHORIZED_BODY,
          HttpStatus.UNAUTHORIZED);
    }
    return new ResponseEntity<>(badgesToJsons(findAll()),
        HttpStatus.OK);
  }

  @Override
  public String badgesToJsons(List<Badge> badgeList) {
    String[] badgesJsonArray = new String[]{""};
    badgeList.forEach(badge -> {
      Gson gson = new Gson();
      String badgeJson = gson.toJson(badge);
      badgesJsonArray[0] =  badgesJsonArray[0].concat(badgeJson + "\n");
    });
    return badgesJsonArray[0];
  }

  @Override
  public ResponseEntity<String> getAuthorizationAndStatusCreated(String authorization, Object object){
    if (authorization == null || !authorization.equals(Message.AUTHORIZATION_OK)) {
      return new ResponseEntity<>(Message.UNAUTHORIZED_BODY,
          HttpStatus.UNAUTHORIZED);
    }
    return new ResponseEntity<>(Message.CREATED_BODY,
        HttpStatus.CREATED);
  }
}
