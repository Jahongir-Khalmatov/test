package lesson2.hometask2_pcmarket.repository;

import lesson2.hometask2_pcmarket.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import lesson2.hometask2_pcmarket.projection.CustomRegion;

@RepositoryRestResource(path = "region",excerptProjection = CustomRegion.class)
public interface RegionRepository extends JpaRepository<Region, Integer> {


}
