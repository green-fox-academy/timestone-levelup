package com.greenfoxacademy.levelup.utility;

import com.greenfoxacademy.levelup.collection.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.Field;

public class Util {

  public static ResponseEntity<String> getAuthorizationAndStatusOk(String authorization,
                                                                   Object object)
      throws Exception {

    if (!authorization.equals(Message.AUTHORIZATION_OK)) {
      return new ResponseEntity<>(Message.UNAUTHORIZED_BODY,
          HttpStatus.UNAUTHORIZED);
    }

    if (hasNullField(object)) {
      return new ResponseEntity<>(Message.UNSUCCESSFUL_BODY,
          HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(Message.SUCCESSFUL_BODY,
        HttpStatus.OK);
  }

  public static ResponseEntity<String> getAuthorizationAndStatusCreated(String authorization,
                                                                        Object object)
      throws Exception {
    if (!authorization.equals(Message.AUTHORIZATION_OK)) {
      return new ResponseEntity<>(Message.UNAUTHORIZED_BODY,
          HttpStatus.UNAUTHORIZED);
    }

    if (hasNullField(object)) {
      return new ResponseEntity<>(Message.UNSUCCESSFUL_BODY,
          HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(Message.CREATED_BODY,
        HttpStatus.CREATED);
  }

  public static ResponseEntity<String> getAuthorization(String authorization) {
    if (authorization.equals(Message.AUTHORIZATION_OK)) {
      return new ResponseEntity<>(Message.BODY,
          HttpStatus.OK);
    }
    return new ResponseEntity<>(Message.UNAUTHORIZED_BODY,
        HttpStatus.UNAUTHORIZED);
  }

  private static boolean hasNullField(Object object) throws IllegalAccessException {
    for (Field field : object.getClass().getDeclaredFields()) {
      field.setAccessible(true);
      if (field.get(object) == null) {
        return true;
      }
    }
    return false;
  }

  public static ResponseEntity<String> getAuthorizationForHeartbeat(String authorization) {
    if (authorization != null && authorization.equals("Ok")) {
      return new ResponseEntity<>(Message.AUTHORIZATION_OK,
          HttpStatus.OK);
    }
    return new ResponseEntity<>(Message.UNAUTHORIZED_BODY,
        HttpStatus.UNAUTHORIZED);
  }

  public static ResponseEntity<String> putBadgeAuthorizationIsOk(String authorization,
                                                                 Object object)
          throws Exception {

    if (!authorization.equals(Message.AUTHORIZATION_OK)) {
      return new ResponseEntity<>(Message.UNAUTHORIZED_BODY,
              HttpStatus.UNAUTHORIZED);
    }
    return new ResponseEntity<>(Message.UPDATED_STATUS,
            HttpStatus.OK);
  }
}

