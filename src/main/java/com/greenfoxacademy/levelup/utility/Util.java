package com.greenfoxacademy.levelup.utility;

import com.greenfoxacademy.levelup.collection.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Util {

  public static ResponseEntity<String> isAuthorized(String authorization) {
    {

      if (authorization.equals(Message.AUTHORIZATION_OK)) {
        return new ResponseEntity<>(Message.BODY,
            HttpStatus.OK);
      }
      return new ResponseEntity<>(Message.ERROR_BODY,
          HttpStatus.UNAUTHORIZED);
    }
  }
}