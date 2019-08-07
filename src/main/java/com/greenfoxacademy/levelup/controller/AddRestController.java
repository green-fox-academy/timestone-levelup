package com.greenfoxacademy.levelup.controller;

import com.greenfoxacademy.levelup.collection.Message;
<<<<<<< HEAD
import com.greenfoxacademy.levelup.model.MockBadgeDTO;
import com.greenfoxacademy.levelup.service.IBadgeService;
=======
import com.greenfoxacademy.levelup.model.BadgeDTO;
>>>>>>> 5ddbf13b2860a51a53db39082e812a00d3da077e
import com.greenfoxacademy.levelup.utility.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddRestController {

  @PostMapping("/api/admin/add")
  public ResponseEntity<String> addAdmin(
      @RequestHeader(value = Message.HEADER_NAME) String authorization,
      @RequestBody BadgeDTO mockBadgeDTO) throws Exception {
    return Util.getAuthorizationAndStatusCreated(authorization, mockBadgeDTO);
  }
}
