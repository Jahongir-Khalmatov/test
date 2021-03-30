package lesson2.hometask2_pcmarket.repository;

import lesson2.hometask2_pcmarket.entity.UserBasket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import lesson2.hometask2_pcmarket.projection.CustomUserBasket;

@RepositoryRestResource(path = "userBasket",excerptProjection = CustomUserBasket.class)
public interface UserBasketRepository extends JpaRepository<UserBasket, Integer> {

}
