package com.greenfoxacademy.levelup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BadgeLibraryController {

  @GetMapping("/badgelibrary")
  public String renderAllBadges() {
    return "badgeLibrary";
  }
}
