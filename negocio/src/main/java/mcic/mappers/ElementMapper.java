package mcic.mappers;

import mcic.dto.ElementDto;
import mcic.entities.Element;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ElementMapper {

  @Mapping(source = "id", target = "id")
  @Mapping(source = "name", target = "name")
  @Mapping(source = "description", target = "description")
  @Mapping(source = "quantity", target = "quantity")
  @Mapping(expression = "java(new String(element.getImage()))", target = "image")
  @Mapping(source="category.name", target = "category")
  ElementDto mapDaoToDto(Element element);

  @Mapping(source = "id", target = "id")
  @Mapping(source = "name", target = "name")
  @Mapping(source = "description", target = "description")
  @Mapping(source = "quantity", target = "quantity")
  @Mapping(expression = "java(element.getImage().getBytes())", target = "image")
  @Mapping(source = "category", target = "category.id")
  Element mapDtoToDao(ElementDto element);
}
