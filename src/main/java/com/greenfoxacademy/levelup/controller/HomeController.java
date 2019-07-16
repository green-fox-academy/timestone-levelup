package com.greenfoxacademy.levelup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
  @RequestMapping("/home")
  public String renderHomePage() {
    return "index";
  }
}
