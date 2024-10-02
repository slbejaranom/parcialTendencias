package mcic.services;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mcic.dto.CategoryDto;
import mcic.entities.Category;
import mcic.mappers.CategoryMapper;
import mcic.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

  private final CategoryRepository categoryRepository;
  private final CategoryMapper mapper;

  public List<CategoryDto> findAll() {
    List<Category> results = categoryRepository.findAll();
    return results
        .stream()
        .map(mapper::mapDaoToDto)
        .toList();
  }
}
