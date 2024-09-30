package mcic.tendencias.parcial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {

  @GetMapping("/")
  public String index(Model model) {
    return "index";
  }
}
