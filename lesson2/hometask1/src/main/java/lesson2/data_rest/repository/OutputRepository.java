package lesson2.data_rest.repository;

import lesson2.data_rest.entity.Output;
import lesson2.data_rest.projection.CustomOutput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "output",excerptProjection = CustomOutput.class)

public interface OutputRepository extends JpaRepository<Output,Integer> {

}
