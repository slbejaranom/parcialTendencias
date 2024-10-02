package mcic.mappers;

import mcic.dto.ElementDto;
import mcic.entities.Element;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class ElementMapper {

  @Mapping(source = "id", target = "id")
  @Mapping(source = "name", target = "name")
  @Mapping(source = "description", target = "description")
  @Mapping(source = "quantity", target = "quantity")
  @Mapping(source = "image", target = "image")
  public abstract ElementDto mapDaoToDto(Element element);
}
