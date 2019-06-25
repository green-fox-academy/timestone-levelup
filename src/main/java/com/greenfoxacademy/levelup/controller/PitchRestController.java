package com.greenfoxacademy.levelup.controller;

import com.greenfoxacademy.levelup.model.Mandatory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PitchRestController {
  private static HttpHeaders httpHeaders = new HttpHeaders();

  public void setHeader(String key, String value) {
    httpHeaders.set(key, value);
  }

  @PutMapping("/api/pitch")
  public ResponseEntity<String> putPitchApi(@RequestBody Mandatory mandatory) {
    setHeader(IPitchRestController.AUTHORIZATION, IPitchRestController.AUTH_OK);

    if (httpHeaders.getValuesAsList(IPitchRestController.AUTHORIZATION).get(0)
        .equals(IPitchRestController.AUTH_OK)) {
      return new ResponseEntity<String>(IPitchRestController.PITCH_SUCCESSFUL_BODY, httpHeaders,
          HttpStatus.OK);
    } else if (httpHeaders.getValuesAsList(IPitchRestController.AUTHORIZATION).get(0)
        .equals(IPitchRestController.AUTH_UNAUTHORIZED)) {
      return new ResponseEntity<String>(IPitchRestController.PITCH_UNAUTHORIZED_BODY, httpHeaders,
          HttpStatus.UNAUTHORIZED);
    }
    return new ResponseEntity<String>(IPitchRestController.PITCH_UNSUCCESFUL_BODY, httpHeaders,
        HttpStatus.NOT_FOUND);
  }
}