package lesson2.hometask2_pcmarket.repository;

import lesson2.hometask2_pcmarket.entity.MyTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import lesson2.hometask2_pcmarket.projection.CustomMyTeam;

@RepositoryRestResource(path = "myteam",excerptProjection = CustomMyTeam.class)
public interface MyTeamRepository extends JpaRepository<MyTeam, Integer> {


}
