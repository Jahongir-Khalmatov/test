package realproject.lesson11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import realproject.lesson11.entity.InputProduct;
import realproject.lesson11.entity.OutputProduct;

public interface OutputProductRepository extends JpaRepository<OutputProduct,Integer> {

}
