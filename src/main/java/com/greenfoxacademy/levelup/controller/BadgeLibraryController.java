package com.greenfoxacademy.levelup.controller;

import com.greenfoxacademy.levelup.utility.Util;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BadgeLibraryController {

  @GetMapping("/badgelibrary")
  public String renderAllBadges(Model model) {
    return "badgeLibrary";
  }
}
