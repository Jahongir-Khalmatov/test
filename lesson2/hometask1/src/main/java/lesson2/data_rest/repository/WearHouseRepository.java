package lesson2.data_rest.repository;

import lesson2.data_rest.entity.WearHouse;
import lesson2.data_rest.projection.CustomWearHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "wearHouse",excerptProjection = CustomWearHouse.class)

public interface WearHouseRepository extends JpaRepository<WearHouse,Integer> {
    boolean existsByName(String name);
}
