package mcic.tendencias.parcial.controller;

import io.micrometer.common.util.StringUtils;
import mcic.dto.ElementPageDto;
import mcic.services.CategoryService;
import mcic.services.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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

  @GetMapping("/findElements/{pageNumber}")
  public String getElementsPaginatedByCategory(
      @PathVariable("pageNumber") int pageNumber,
      @RequestParam(value = "nameCoincidence", defaultValue = "") String nameCoincidence,
      @RequestParam(name = "category", defaultValue = "-1") int category,
      Model model
  ) {
    if(StringUtils.isBlank(nameCoincidence) && category == -1){
      model.addAttribute("elements",
          elementService.findElementsPaginated(pageNumber));
      return "main :: articulos";
    }
    if(category == -1) {
      model.addAttribute("elements",
          elementService.findElementsPaginatedByName(pageNumber, nameCoincidence));
      return "main :: articulos";
    }
    if(StringUtils.isBlank(nameCoincidence)) {
      model.addAttribute("elements",
          elementService.findElementsPaginatedByCategory(pageNumber, category));
    }
    else {
      model.addAttribute("elements",
          elementService.findElementsPaginatedByNameAndCategory(pageNumber, nameCoincidence,category));
    }
    return "main :: articulos";
  }
}
