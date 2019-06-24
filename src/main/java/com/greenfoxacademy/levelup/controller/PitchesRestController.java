package com.greenfoxacademy.levelup.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PitchesRestController {

  @GetMapping("api/pitches")
  public ResponseEntity<String> getPitchesApi() {
    HttpHeaders responseHeader = new HttpHeaders();
    responseHeader
        .set(IPItchesRestController.HEADER_NAME, IPItchesRestController.AUTHORIZATION_STATUS_OK);

    if (responseHeader.getValuesAsList(IPItchesRestController.HEADER_NAME).get(0)
        .equals(IPItchesRestController.AUTHORIZATION_STATUS_OK)) {
      return ResponseEntity.ok()
          .headers(responseHeader)
          .body(IPItchesRestController.BODY);
    }

    return ResponseEntity.status(401)
        .headers(responseHeader)
        .body(IPItchesRestController.ERROR_BODY);
  }
}
