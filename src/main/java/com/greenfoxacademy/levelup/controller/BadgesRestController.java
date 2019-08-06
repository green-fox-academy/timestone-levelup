package com.greenfoxacademy.levelup.controller;

import com.greenfoxacademy.levelup.collection.Message;
import com.greenfoxacademy.levelup.model.Badge;
import com.greenfoxacademy.levelup.service.IBadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BadgesRestController {

  @Autowired
  private IBadgeService badgeService;

  @GetMapping("/api/badges")
  public ResponseEntity<String> showBadges(
      @RequestHeader(value = Message.HEADER_NAME, required = false) String authorization) {
    return badgeService.getBadgesJsonObjects(authorization);
  }

  @PostMapping("/api/badges")
  public ResponseEntity<String> postBadges(@RequestHeader(value = Message.HEADER_NAME, required = false) String authorization, @RequestBody Badge badge) {
    return badgeService.getAuthorizationAndStatusCreated(authorization, badge);
  }
}
