package com.greenfoxacademy.levelup.controller;

import com.greenfoxacademy.levelup.collection.Message;
import com.greenfoxacademy.levelup.utility.Util;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BadgesRestController {

  @GetMapping("/api/badges")
  public ResponseEntity<String> showBadges(
      @RequestHeader(value = Message.HEADER_NAME, required = false) String authorization) {
    return Util.getBadgesAuthorizatioAndStatus(authorization);
  }
}