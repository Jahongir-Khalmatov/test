package lesson2.hometask2_pcmarket.repository;

import lesson2.hometask2_pcmarket.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import lesson2.hometask2_pcmarket.projection.CustomDistrict;

@RepositoryRestResource(path = "district",excerptProjection = CustomDistrict.class)
public interface DistrictRepository extends JpaRepository<District, Integer> {


}
