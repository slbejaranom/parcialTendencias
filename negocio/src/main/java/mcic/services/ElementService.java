package mcic.services;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import mcic.dto.ElementDto;
import mcic.entities.Element;
import mcic.mappers.ElementMapper;
import mcic.repositories.ElementRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ElementService {

  private final ElementRepository elementRepository;
  private final ElementMapper mapper;

  public void registerElement(ElementDto elementDto) {
    elementDto.setId(UUID.randomUUID().toString());
    Element element = mapper.mapDtoToDao(elementDto);
    elementRepository.save(element);
  }
}
