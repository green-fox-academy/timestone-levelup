package com.greenfoxacademy.levelup.utility;

import com.greenfoxacademy.levelup.collection.Message;
import com.greenfoxacademy.levelup.model.MockBadgeDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Util {

  public static ResponseEntity<String> isAuthorized(String authorization) {
    if (authorization.equals(Message.AUTHORIZATION_OK)) {
      return new ResponseEntity<>(Message.BODY,
          HttpStatus.OK);
    }
    return new ResponseEntity<>(Message.ERROR_BODY,
        HttpStatus.UNAUTHORIZED);
  }

  public static ResponseEntity<String> getAdminObjectAndAuthorization(MockBadgeDTO mockBadgeDTO,
      String authorization) {
    if (authorization.equals("")) {
      return new ResponseEntity<>(Message.UNAUTHORIZED_BODY, HttpStatus.UNAUTHORIZED);
    } else if (mockBadgeDTO.getLevels() == null || mockBadgeDTO.getName() == null
        || mockBadgeDTO.getTag() == null || mockBadgeDTO.getVersion() == null) {
      return new ResponseEntity<>(Message.UNSUCCESSFUL_BODY, HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(Message.SUCCESSFUL_BODY, HttpStatus.CREATED);
  }
}
