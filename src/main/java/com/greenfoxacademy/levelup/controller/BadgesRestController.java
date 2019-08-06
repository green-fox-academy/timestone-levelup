package com.greenfoxacademy.levelup.controller;

import com.greenfoxacademy.levelup.collection.Message;
import com.greenfoxacademy.levelup.model.Badge;
import com.greenfoxacademy.levelup.service.IBadgeService;
import com.greenfoxacademy.levelup.utility.Util;
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

  @GetMapping("/api/badge/{badgeid}")
  public ResponseEntity<String> getBadgeJsonById(@PathVariable(name = "badgeid") long badgeId,
      @RequestHeader(value = Message.HEADER_NAME, required = false) String authorization) {
    return badgeService.getBadgeJsonById(badgeId, authorization);
  }

  @PutMapping("/api/badges/{badgeid}")
  public ResponseEntity<String> putBadgeById(@PathVariable("badgeid") long id,
      @RequestHeader(value = Message.HEADER_NAME) String authorization,
      @RequestBody Badge badge) throws Exception {
    badge = badgeService.findById(id);
    return Util.putBadgeAuthorizationIsOk(authorization, badge);
  }
}
