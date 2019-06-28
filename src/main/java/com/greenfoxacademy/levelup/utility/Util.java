package com.greenfoxacademy.levelup.utility;

import com.greenfoxacademy.levelup.collection.Message;
import com.greenfoxacademy.levelup.model.MockObjectDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Util {

  public static ResponseEntity<String> getAdminObjectAndAuthorization(MockObjectDTO objectDTO, String authorization) {
    if (authorization.equals("")) {
      return new ResponseEntity<>(Message.getUnauthorizedBody(), HttpStatus.UNAUTHORIZED);
    } else if (objectDTO.getLevels() == null || objectDTO.getName() == null || objectDTO.getTag() == null || objectDTO.getVersion() == null) {
      return new ResponseEntity<>(Message.getUnsuccessfulBody(), HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(Message.getSuccessfulBody(), HttpStatus.CREATED);
  }
}