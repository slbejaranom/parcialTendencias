package mcic.tendencias.parcial.controller;

import mcic.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {

  private final CategoryService categoryService;

  @Autowired
  public ThymeleafController(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("categories", categoryService.findAll());
    return "main";
  }
}
