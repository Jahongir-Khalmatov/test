package realproject.lesson11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import realproject.lesson11.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    boolean existsByName(String name);
}
