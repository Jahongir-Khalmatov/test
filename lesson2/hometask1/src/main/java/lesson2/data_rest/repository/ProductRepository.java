package lesson2.data_rest.repository;

import lesson2.data_rest.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "product")

public interface ProductRepository extends JpaRepository<Product,Integer> {
    boolean existsByCode(String code);
}
