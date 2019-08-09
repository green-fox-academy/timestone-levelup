package com.greenfoxacademy.levelup.controller;

import com.greenfoxacademy.levelup.service.IBadgeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

  @GetMapping("/badgelibrary/create")
  public String renderCreateForm() {
    return "createBadge";
  }
}
