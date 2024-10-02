package mcic.entities;

import static jakarta.persistence.FetchType.EAGER;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "element")
@NoArgsConstructor
public class Element {

  @Id
  private String id;
  private String name;
  private String description;
  private int quantity;
  @Lob @Column(columnDefinition = "bytea")
  private byte[] image;

  @ManyToOne(fetch = EAGER)
  @JoinColumn(name = "category_id", updatable = false, insertable = false)
  private Category category;
}
