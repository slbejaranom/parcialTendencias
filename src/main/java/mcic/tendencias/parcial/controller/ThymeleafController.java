package mcic.tendencias.parcial.controller;

import mcic.dto.ElementPageDto;
import mcic.services.CategoryService;
import mcic.services.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {

  private final CategoryService categoryService;
  private final ElementService elementService;

  @Autowired
  public ThymeleafController(
      CategoryService categoryService,
      ElementService elementService) {
    this.categoryService = categoryService;
    this.elementService = elementService;
  }

  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("categories", categoryService.findAll());
    model.addAttribute("elements", elementService.findElementsPaginated(0));
    return "main";
  }

  @GetMapping("/categories")
  public String getCategories(Model model) {
    model.addAttribute("categories", categoryService.findAll());
    return "main :: #categoria";
  }
}
