package com.greenfoxacademy.levelup.controller;

import com.greenfoxacademy.levelup.configuration.IAuthenticationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/*@RestController
public class SecurityController {

  @GetMapping("/username")
  public String currentUserNameSimple(Principal principal) {
    return principal.getName();
  }
}*/
