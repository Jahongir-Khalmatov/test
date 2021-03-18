package realproject.lesson11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import realproject.lesson11.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    boolean existsByCode(String code);
}
