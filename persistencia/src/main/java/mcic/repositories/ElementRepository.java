package mcic.repositories;

import mcic.entities.Element;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElementRepository extends JpaRepository<Element, String> {

  Page<Element> findAll(Pageable pageable);
  Page<Element> findAllByCategoryId(Pageable pageable, int categoryId);
  Page<Element> findAllByNameContainsAndCategoryId(Pageable pageable, String nameCoincidence,
      int categoryId);
}
