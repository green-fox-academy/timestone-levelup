package com.greenfoxacademy.levelup.controller;

import com.greenfoxacademy.levelup.model.MockBadgeDTO;
import com.greenfoxacademy.levelup.utility.Util;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddRestController {

  @PostMapping("/api/admin/add")
  public ResponseEntity<String> addAdmin(@RequestHeader(value = "Authorization", required = false)  String authorization, @RequestBody MockBadgeDTO mockBadgeDTO) {
    return Util.getAdminObjectAndAuthorization(mockBadgeDTO, authorization);
  }
}
