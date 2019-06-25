package com.greenfoxacademy.levelup.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PitchesRestController {
  private HttpHeaders responseHeader = new HttpHeaders();
  private static boolean isAuthorized = true;

  public static void setAuthorized(boolean authorized) {
    isAuthorized = authorized;
  }

  @GetMapping("api/pitches")
  public ResponseEntity<String> getPitchesApi() {
    responseHeader.set(IPItchesRestController.HEADER_NAME, "");

    if (isAuthorized == true) {
      return new ResponseEntity<String>(IPItchesRestController.BODY, responseHeader,
          HttpStatus.OK);
    }
    return new ResponseEntity<String>(IPItchesRestController.ERROR_BODY, responseHeader,
        HttpStatus.UNAUTHORIZED);
  }
}