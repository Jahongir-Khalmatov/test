package lesson2.data_rest.repository;

import lesson2.data_rest.entity.Category;
import lesson2.data_rest.projection.CustomCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "category",excerptProjection = CustomCategory.class)
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    boolean existsByName(String name);
}
