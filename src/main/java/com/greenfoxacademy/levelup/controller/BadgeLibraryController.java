package com.greenfoxacademy.levelup.controller;


import com.greenfoxacademy.levelup.model.Badge;
import com.greenfoxacademy.levelup.model.BadgeLevel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class BadgeLibraryController {

  @GetMapping("/badgelibrary")
  public String renderAllBadges(Model model) {
    List<BadgeLevel> levels = new ArrayList<>();
    Badge badge1 = new Badge("1.0", "Super Badge", "god", levels);
    Badge badge2 = new Badge("2.0", "Best Mentor", "mentor", levels);
    Badge badge3 = new Badge("3.0", "Best Colleague", "general", levels);
    Badge badge4 = new Badge("4.0", "Lame Jokes", "general", levels);
    List<Badge> badges = new ArrayList<>();
    badges.add(badge1);
    badges.add(badge2);
    badges.add(badge3);
    badges.add(badge4);
    model.addAttribute("badges", badges);
    return "badgeLibrary";
  }
}
