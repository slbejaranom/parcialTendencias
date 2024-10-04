package mcic.tendencias.parcial.controller;

import java.util.Map;
import mcic.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {

  private final CategoryService categoryService;

  @Autowired
  private CategoryController(CategoryService categoryService){
    this.categoryService = categoryService;
  }

  @PostMapping
  public void saveCategory(@RequestBody Map<String, String> payload) {
    categoryService.saveCategory(payload.get("name"));
  }
}
