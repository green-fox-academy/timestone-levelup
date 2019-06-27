package com.greenfoxacademy.levelup.controller;

import com.greenfoxacademy.levelup.model.BadgeDTO;
import com.greenfoxacademy.levelup.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BadgesRestController {

  @GetMapping("/api/badges")
  public  ResponseEntity<Object> showBadges(@RequestHeader(value = "Authorization", required = false) String authorization) {

    if (authorization == null || authorization.equals("")) {
     return new ResponseEntity<>(new ErrorMessage("Unauthorized"), HttpStatus.UNAUTHORIZED);
    }
    return new ResponseEntity<>(new BadgeDTO(), HttpStatus.OK);
  }
}