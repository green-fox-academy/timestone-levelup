package com.greenfoxacademy.levelup.controller;

import com.greenfoxacademy.levelup.collection.Message;
import com.greenfoxacademy.levelup.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

  @Autowired
  private IUserService userService;

  @GetMapping("/api/users")
  public ResponseEntity<String> getUsers(@RequestHeader(value = Message.HEADER_NAME, required = false) String authorization) {
    return userService.getUserJsonObjects(authorization);
  }
}
