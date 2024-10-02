package mcic.entities;

import static jakarta.persistence.FetchType.EAGER;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "category")
@NoArgsConstructor
@Getter
@Setter
public class Category {

  @Id
  private int id;
  private String name;

  @OneToMany(fetch = EAGER, mappedBy = "category")
  List<Element> elements;
}
