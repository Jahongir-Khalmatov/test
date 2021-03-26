package lesson2.data_rest.repository;

import lesson2.data_rest.entity.InputProduct;
import lesson2.data_rest.projection.CustomInputProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "inputProduct",excerptProjection = CustomInputProduct.class)

public interface InputProductRepository extends JpaRepository<InputProduct,Integer> {

}
