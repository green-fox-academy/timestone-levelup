package com.greenfoxacademy.levelup.controller;

import com.greenfoxacademy.levelup.model.Pitch;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PitchRestController {
  HttpHeaders httpHeaders = new HttpHeaders();
  private static boolean isAuthorized = true;
  private static boolean isMissingField = false;

  public static void setIsAuthorized(boolean authorized) {
    isAuthorized = authorized;
  }

  public static void setIsMissingField(boolean missingField) {
    isMissingField = missingField;
  }

  @PostMapping("/api/pitch")
  public ResponseEntity<String> postPitchApi(@RequestBody Pitch pitch) {
    httpHeaders.set("Authorization", "");

    if (isAuthorized) {
      return new ResponseEntity<String>(IPitchRestInterface.PITCH_SUCCESSFUL_BODY, httpHeaders,
          HttpStatus.CREATED);
    } else if (isMissingField) {
      return new ResponseEntity<String>(IPitchRestInterface.PITCH_UNSUCCESFUL_BODY, httpHeaders,
          HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<String>(IPitchRestInterface.PITCH_UNAUTHORIZED_BODY, httpHeaders,
        HttpStatus.UNAUTHORIZED);
  }
}