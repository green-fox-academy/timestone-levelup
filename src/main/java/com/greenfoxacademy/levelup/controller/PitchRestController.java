package com.greenfoxacademy.levelup.controller;

import com.greenfoxacademy.levelup.model.Mandatory;
import com.greenfoxacademy.levelup.utility.Util;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PitchRestController {

  @PutMapping("/api/pitch")
  public ResponseEntity<String> putPitchApi(@RequestHeader(value="Authorization") String authorization,
      @RequestBody Mandatory mandatory) throws  Exception {

    return Util.isAuthorized(authorization, mandatory);
    }
}