package com.greenfoxacademy.levelup.controller;

import com.greenfoxacademy.levelup.collection.Message;
import com.greenfoxacademy.levelup.service.IBadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

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
}
