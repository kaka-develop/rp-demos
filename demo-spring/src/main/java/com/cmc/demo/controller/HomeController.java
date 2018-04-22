package com.cmc.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Home controller.
 */
@Controller
public class HomeController {

  /**
   * get request to home page.
   * 
   * @return welcome view.
   */
  @GetMapping(value = { "/", "/home" })
  public String getHome() {
    return "home";
  }

}
