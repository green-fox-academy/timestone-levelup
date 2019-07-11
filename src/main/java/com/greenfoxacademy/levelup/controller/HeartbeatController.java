package com.greenfoxacademy.levelup.controller;

import com.greenfoxacademy.levelup.collection.Message;
import com.greenfoxacademy.levelup.utility.Util;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@Controller
public class HeartbeatController {
  @GetMapping("/heartbeat")
  public ResponseEntity<String> showHeartbeat(@RequestHeader(value = Message.HEADER_NAME, required = false) String authorization) {
    return Util.getAuthorizationForHeartbeat(authorization);
  }
}
