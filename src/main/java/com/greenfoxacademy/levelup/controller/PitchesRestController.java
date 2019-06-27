package com.greenfoxacademy.levelup.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PitchesRestController {

  @GetMapping("api/pitches")
  public ResponseEntity<String> getPitchesApi(@RequestHeader("Authorization") String authorization) {

    if (authorization.equals("Full")) {
      return new ResponseEntity<String>(IPItchesRestController.BODY,
          HttpStatus.OK);
    }
    return new ResponseEntity<String>(IPItchesRestController.ERROR_BODY,
        HttpStatus.UNAUTHORIZED);
  }
}