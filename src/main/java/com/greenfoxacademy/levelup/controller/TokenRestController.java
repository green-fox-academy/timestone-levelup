package com.greenfoxacademy.levelup.controller;

import com.greenfoxacademy.levelup.utility.GenerateToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class TokenRestController {

  @GetMapping("/token")
  public Principal currentUserName(Principal principal) {
    GenerateToken.createJWT();
    return principal;
  }
}
