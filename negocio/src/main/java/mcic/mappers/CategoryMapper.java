package mcic.mappers;

import mcic.dto.CategoryDto;
import mcic.entities.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

  @Mapping(source = "id", target = "id")
  @Mapping(source = "name", target = "name")
  CategoryDto mapDaoToDto(Category category);
}
