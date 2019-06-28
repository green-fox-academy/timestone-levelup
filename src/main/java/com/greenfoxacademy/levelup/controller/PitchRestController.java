package com.greenfoxacademy.levelup.controller;

import com.greenfoxacademy.levelup.model.Pitch;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PitchRestController {

  @PostMapping("/api/pitch")
  public ResponseEntity<String> postPitchApi(@RequestHeader(value = "Authorization", required = false) String authorization, @RequestBody(required = false) Pitch pitch) throws IllegalAccessException {

    if (authorization == null || authorization.equals("")) {
      return new ResponseEntity<>(IPitchRestInterface.PITCH_UNAUTHORIZED_BODY,
              HttpStatus.UNAUTHORIZED);
    } else if (pitch.hasNullField() == true) {
      return new ResponseEntity<>(IPitchRestInterface.PITCH_UNSUCCESFUL_BODY,
              HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(IPitchRestInterface.PITCH_SUCCESSFUL_BODY,
            HttpStatus.CREATED);
  }
}