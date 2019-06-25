package com.greenfoxacademy.levelup.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PitchesRestController {
  private HttpHeaders responseHeader = new HttpHeaders();
  boolean isAuthorized;

  public void setAuthorized(boolean authorized) {
    isAuthorized = authorized;
  }

  @GetMapping("api/pitches")
  public ResponseEntity<String> getPitchesApiError() {
    responseHeader.set(IPItchesRestController.HEADER_NAME, "");

    setAuthorized(true);

    if (isAuthorized == true) {
      return new ResponseEntity<String>(IPItchesRestController.BODY, responseHeader,
          HttpStatus.ACCEPTED);
    }
    return new ResponseEntity<String>(IPItchesRestController.ERROR_BODY, responseHeader,
        HttpStatus.UNAUTHORIZED);
  }
}