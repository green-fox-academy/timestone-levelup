package com.greenfoxacademy.levelup.controller;

import com.greenfoxacademy.levelup.service.IPitchService;
import com.greenfoxacademy.levelup.utility.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PitchesRestController {
  @Autowired
  IPitchService pitchService;

  @GetMapping("/api/pitches")
  public ResponseEntity<String> getPitchesApi(
      @RequestHeader(value = "Authorization", required = false) String authorization) {
    return pitchService.getPitches(authorization);
  }
}
