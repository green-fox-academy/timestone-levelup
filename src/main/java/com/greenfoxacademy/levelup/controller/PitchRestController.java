package com.greenfoxacademy.levelup.controller;

import com.greenfoxacademy.levelup.model.Mandatory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PitchRestController {

  private boolean hasMissingField (Mandatory mandatory) throws Exception {
    return mandatory.hasNullField();
  }

  @PutMapping("/api/pitch")
  public ResponseEntity<String> putPitchApi(@RequestHeader(value="Authorization") String authorization,
      @RequestBody Mandatory mandatory) throws  Exception {

    if (authorization.equals("Full") && hasMissingField(mandatory)) {
      return new ResponseEntity<>(IPitchRestController.PITCH_UNSUCCESFUL_BODY,
          HttpStatus.NOT_FOUND);
    }else if (authorization.equals("Full")) {
      return new ResponseEntity<>(IPitchRestController.PITCH_SUCCESSFUL_BODY,
          HttpStatus.OK);
    }
    return new ResponseEntity<>(IPitchRestController.PITCH_UNAUTHORIZED_BODY,
        HttpStatus.UNAUTHORIZED);
    }
}