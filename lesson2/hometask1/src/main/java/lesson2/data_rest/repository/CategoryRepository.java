package lesson2.data_rest.repository;

import lesson2.data_rest.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "category")
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    boolean existsByName(String name);
}
