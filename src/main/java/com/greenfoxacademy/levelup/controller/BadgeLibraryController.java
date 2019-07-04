package com.greenfoxacademy.levelup.controller;

import com.greenfoxacademy.levelup.model.Badge;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BadgeLibraryController {

  @GetMapping("/badgelibrary")
  public List<Badge> renderAllBadges() {

  }


}
