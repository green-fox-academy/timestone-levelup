package com.greenfoxacademy.levelup.utility;

import com.google.gson.Gson;
import com.greenfoxacademy.levelup.collection.Message;
import com.greenfoxacademy.levelup.model.Pitch;
import java.lang.reflect.Field;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.greenfoxacademy.levelup.model.Badge;
import com.greenfoxacademy.levelup.model.User;
import java.util.List;
import java.util.stream.Collectors;

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

  public static ResponseEntity<String> getBadgesAuthorizationAndStatus(String authorization) {
    if (authorization == null || !authorization.equals(Message.AUTHORIZATION_OK)) {
      return new ResponseEntity<>(Message.UNAUTHORIZED_BODY, HttpStatus.UNAUTHORIZED);
    }
    return new ResponseEntity<>(Message.BADGE_SUCCESFUL_BODY, HttpStatus.OK);
  }

  public static boolean hasNullField(Object object) throws IllegalAccessException {
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

  public static ResponseEntity<String> putBadgeAuthorizationIsOk(String authorization)
          throws Exception {

    if (!authorization.equals(Message.AUTHORIZATION_OK)) {
      return new ResponseEntity<>(Message.UNAUTHORIZED_BODY,
              HttpStatus.UNAUTHORIZED);
    }
    return new ResponseEntity<>(Message.UPDATED_STATUS,
            HttpStatus.OK);
  }

  public static String convertListOfUserToJson(List<User> models) {
    String modelsJsonString = models.stream().map(model -> convertModelToJson(model)).collect(Collectors.joining("\n"));
    return modelsJsonString;
  }

  public static String convertListOfBadgeToJson(List<Badge> models) {
    String modelsJsonString = models.stream().map(model -> convertModelToJson(model)).collect(Collectors.joining("\n"));
    return modelsJsonString;
  }

  public static String convertListOfPitchToJson(List<Pitch> models) {
    String modelsJsonString = models.stream().map(model -> convertModelToJson(model)).collect(Collectors.joining("\n"));
    return modelsJsonString;
  }

  public static String convertModelToJson(Object object) {
    Gson gson = new Gson();
    return gson.toJson(object);

  }
}

