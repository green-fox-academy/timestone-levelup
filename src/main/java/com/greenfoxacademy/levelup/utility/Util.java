package com.greenfoxacademy.levelup.utility;

import com.greenfoxacademy.levelup.collection.Message;
import com.greenfoxacademy.levelup.model.MockBadgeDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Util {

  public static ResponseEntity<String> getAdminObjectAndAuthorization(MockBadgeDTO mockBadgeDTO, String authorization) {
    if (authorization.equals("")) {
      return new ResponseEntity<>(Message.getUnauthorizedBody(), HttpStatus.UNAUTHORIZED);
    } else if (mockBadgeDTO.getLevels() == null || mockBadgeDTO.getName() == null || mockBadgeDTO.getTag() == null || mockBadgeDTO.getVersion() == null) {
      return new ResponseEntity<>(Message.getUnsuccessfulBody(), HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(Message.getSuccessfulBody(), HttpStatus.CREATED);
  }
}