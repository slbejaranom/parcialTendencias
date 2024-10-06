package mcic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ElementDto {
  private String id;
  private String name;
  private String description;
  private int quantity;
  private String image;
  private String category;
}
