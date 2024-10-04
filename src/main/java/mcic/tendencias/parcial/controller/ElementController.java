package mcic.tendencias.parcial.controller;

import mcic.dto.ElementDto;
import mcic.services.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/elements")
public class ElementController {

  private final ElementService elementService;

  @Autowired
  public ElementController(ElementService elementService) {
    this.elementService = elementService;
  }

  @PostMapping
  public void registerElement(@RequestBody ElementDto elementDto) {
    elementService.registerElement(elementDto);
  }
}
