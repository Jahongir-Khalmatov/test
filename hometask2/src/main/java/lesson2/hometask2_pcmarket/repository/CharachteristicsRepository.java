package lesson2.hometask2_pcmarket.repository;

import lesson2.hometask2_pcmarket.entity.Charachteristics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import lesson2.hometask2_pcmarket.projection.CustomCharacteristics;

@RepositoryRestResource(path = "characteristics",excerptProjection = CustomCharacteristics.class)
public interface CharachteristicsRepository extends JpaRepository<Charachteristics, Integer> {

}
