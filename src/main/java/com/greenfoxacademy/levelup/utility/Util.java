package com.greenfoxacademy.levelup.utility;

import com.greenfoxacademy.levelup.collection.Message;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.greenfoxacademy.levelup.model.Badge;
import com.greenfoxacademy.levelup.model.BadgeLevel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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

  public static List<Badge> createListOfBadges() {
    List<BadgeLevel> levels = new ArrayList<>();
    Badge badge1 = new Badge("1.0", "Super Badge", "god", levels);
    Badge badge2 = new Badge("2.0", "Best Mentor", "mentor", levels);
    Badge badge3 = new Badge("3.0", "Best Colleague", "general", levels);
    Badge badge4 = new Badge("4.0", "Lame Jokes", "general", levels);
    List<Badge> badges = new ArrayList<>();
    badges.add(badge1);
    badges.add(badge2);
    badges.add(badge3);
    badges.add(badge4);
    return badges;
  }
}
