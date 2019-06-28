package com.greenfoxacademy.levelup.utility;

import com.greenfoxacademy.levelup.collection.Message;
import com.greenfoxacademy.levelup.model.Mandatory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Util {
  public static ResponseEntity<String> isAuthorized(String authorization, Mandatory mandatory) throws Exception {

    if (authorization.equals(Message.AUTHORIZATION_OK) && mandatory.hasNullField()) {
      return new ResponseEntity<>(Message.PITCH_UNSUCCESSFUL_BODY,
          HttpStatus.NOT_FOUND);
    }else if (authorization.equals(Message.AUTHORIZATION_OK)) {
      return new ResponseEntity<>(Message.PITCH_SUCCESSFUL_BODY,
          HttpStatus.OK);
    }
    return new ResponseEntity<>(Message.PITCH_UNAUTHORIZED_BODY,
        HttpStatus.UNAUTHORIZED);
  }
}