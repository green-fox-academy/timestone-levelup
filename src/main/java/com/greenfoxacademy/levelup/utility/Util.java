package com.greenfoxacademy.levelup.utility;

import com.greenfoxacademy.levelup.collection.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Util {

  public static ResponseEntity<String> showBadges(String authorization) {

    if (authorization == null || authorization.equals("")) {
      return new ResponseEntity<String>(Message.badgeUnsuccessfulBody, HttpStatus.UNAUTHORIZED);
    }
    return new ResponseEntity<String>(Message.badgeSuccessfulBody, HttpStatus.OK);
  }
}
