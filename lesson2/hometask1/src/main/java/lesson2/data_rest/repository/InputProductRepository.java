package lesson2.data_rest.repository;

import lesson2.data_rest.entity.InputProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "inputProduct")

public interface InputProductRepository extends JpaRepository<InputProduct,Integer> {

}
