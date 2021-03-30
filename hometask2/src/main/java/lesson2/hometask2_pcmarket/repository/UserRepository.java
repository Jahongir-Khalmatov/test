package lesson2.hometask2_pcmarket.repository;

import lesson2.hometask2_pcmarket.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import lesson2.hometask2_pcmarket.projection.CustomUser;

@RepositoryRestResource(path = "user",excerptProjection = CustomUser.class)
public interface UserRepository extends JpaRepository<User, Integer> {


}
