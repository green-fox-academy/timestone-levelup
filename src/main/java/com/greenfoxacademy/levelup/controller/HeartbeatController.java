package com.greenfoxacademy.levelup.controller;

import com.greenfoxacademy.levelup.collection.Message;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@Controller
public class HeartbeatController {
  @GetMapping("/heartbeat")
  public String showHeartbeat(@RequestHeader(value = "Authorization", required = false) String authorization) {
    HttpHeaders responseHeader = new HttpHeaders();
    responseHeader.set("Authorization", "OK");
    if (authorization.equals("Ok")) {
      return new ResponseEntity<>(Message.AUTHORIZATION_OK,
          HttpStatus.OK).toString();
    }
    return new ResponseEntity<>(Message.UNAUTHORIZED_BODY,
        HttpStatus.UNAUTHORIZED).toString();
  }
}
