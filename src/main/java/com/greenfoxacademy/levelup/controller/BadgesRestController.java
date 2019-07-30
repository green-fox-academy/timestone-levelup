package com.greenfoxacademy.levelup.controller;

import com.greenfoxacademy.levelup.collection.Message;
import com.greenfoxacademy.levelup.model.Badge;
import com.greenfoxacademy.levelup.service.IBadgeService;
import com.greenfoxacademy.levelup.utility.Util;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BadgesRestController {

  private final IBadgeService badgeService;

  public BadgesRestController(IBadgeService badgeService) {
    this.badgeService = badgeService;
  }

  @GetMapping("/api/badges")
  public ResponseEntity<String> showBadges(
      @RequestHeader(value = Message.HEADER_NAME, required = false) String authorization) {
    return Util.getBadgesAuthorizationAndStatus(authorization);
  }

  @PostMapping("/api/badges")
  public ResponseEntity<String> postBadges(@RequestHeader(value = Message.HEADER_NAME, required = false) String authorization, @RequestBody Badge badge) throws Exception {
    return Util.getAuthorizationAndStatusCreated(authorization, badge);
  }
}
