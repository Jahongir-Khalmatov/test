package lesson2.data_rest.repository;

import lesson2.data_rest.entity.Product;
import lesson2.data_rest.projection.CustomProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "product",excerptProjection = CustomProduct.class)

public interface ProductRepository extends JpaRepository<Product,Integer> {
    boolean existsByCode(String code);
}
