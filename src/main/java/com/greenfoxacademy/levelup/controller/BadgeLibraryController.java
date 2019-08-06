package com.greenfoxacademy.levelup.controller;

import com.greenfoxacademy.levelup.service.IBadgeService;
import com.greenfoxacademy.levelup.utility.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BadgeLibraryController {

  @Autowired
  IBadgeService badgeService;

  @GetMapping("/badgelibrary")
  public String renderAllBadges(Model model) {
    model.addAttribute("badges", badgeService.findAll());
    return "badgeLibrary";
  }
}
