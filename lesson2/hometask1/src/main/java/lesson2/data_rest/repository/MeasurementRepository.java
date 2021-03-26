package lesson2.data_rest.repository;

import lesson2.data_rest.entity.Measurement;
import lesson2.data_rest.projection.CustomMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "measurement",excerptProjection = CustomMeasurement.class)

public interface MeasurementRepository extends JpaRepository<Measurement,Integer> {
    boolean existsByName(String name);

}
