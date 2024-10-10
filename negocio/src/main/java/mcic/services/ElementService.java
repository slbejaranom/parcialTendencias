package mcic.services;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import mcic.dto.ElementDto;
import mcic.dto.ElementPageDto;
import mcic.entities.Element;
import mcic.mappers.ElementMapper;
import mcic.repositories.CategoryRepository;
import mcic.repositories.ElementRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ElementService {

  private final ElementRepository elementRepository;
  private final CategoryRepository categoryRepository;
  private final ElementMapper mapper;

  public void registerElement(ElementDto elementDto) {
    elementDto.setId(UUID.randomUUID().toString());
    Element element = mapper.mapDtoToDao(elementDto);
    element.setCategory(categoryRepository.getReferenceById(element.getCategory().getId()));
    elementRepository.save(element);
  }

  public ElementPageDto findElementsPaginated(int pageNumber) {
    Pageable pageable = PageRequest.of(pageNumber, 8);
    Page<Element> pagedElements = elementRepository.findAll(pageable);
    List<ElementDto> elementsFromDatabase = pagedElements
        .stream()
        .map(mapper::mapDaoToDto)
        .toList();
    return ElementPageDto
        .builder()
        .pageQuantity(pagedElements.getTotalPages())
        .elements(elementsFromDatabase)
        .build();
  }

  public ElementPageDto findElementsPaginatedByCategory(int pageNumber, int category) {
    Pageable pageable = PageRequest.of(pageNumber, 8);
    Page<Element> pagedElements = elementRepository.findAllByCategoryId(pageable, category);
    List<ElementDto> elementsFromDatabase = pagedElements
        .stream()
        .map(mapper::mapDaoToDto)
        .toList();
    return ElementPageDto
        .builder()
        .pageQuantity(pagedElements.getTotalPages())
        .elements(elementsFromDatabase)
        .build();

  }

  public ElementPageDto findElementsPaginatedByNameAndCategory(int pageNumber, String nameCoincidence, int category) {
    Pageable pageable = PageRequest.of(pageNumber, 8);
    Page<Element> pagedElements = elementRepository.findAllByNameContainsAndCategoryId(pageable, nameCoincidence, category);
    List<ElementDto> elementsFromDatabase = pagedElements
        .stream()
        .map(mapper::mapDaoToDto)
        .toList();
    return ElementPageDto
        .builder()
        .pageQuantity(pagedElements.getTotalPages())
        .elements(elementsFromDatabase)
        .build();

  }
}
