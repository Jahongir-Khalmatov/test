package lesson2.data_rest.repository;

import lesson2.data_rest.entity.OutputProduct;
import lesson2.data_rest.projection.CustomOutputProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "outputProduct",excerptProjection = CustomOutputProduct.class)

public interface OutputProductRepository extends JpaRepository<OutputProduct,Integer> {

}
