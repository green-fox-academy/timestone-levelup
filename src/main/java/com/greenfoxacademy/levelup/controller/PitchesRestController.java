package com.greenfoxacademy.levelup.controller;

import com.greenfoxacademy.levelup.collection.Message;
import com.greenfoxacademy.levelup.utility.Util;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PitchesRestController {

  @GetMapping("api/pitches")
  public ResponseEntity<String> getPitchesApi(
      @RequestHeader(Message.HEADER_NAME) String authorization) {
    return Util.getAuthorization(authorization);
  }
}
