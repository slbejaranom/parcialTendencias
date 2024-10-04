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
  @Mapping(source = "image", target = "image")
  ElementDto mapDtoToDao(Element element);

  @Mapping(source = "id", target = "id")
  @Mapping(source = "name", target = "name")
  @Mapping(source = "description", target = "description")
  @Mapping(source = "quantity", target = "quantity")
  @Mapping(source = "image", target = "image")
  @Mapping(constant = "0", target = "category.id")
  Element mapDtoToDao(ElementDto element);
}
