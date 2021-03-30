package lesson2.hometask2_pcmarket.repository;

import lesson2.hometask2_pcmarket.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import lesson2.hometask2_pcmarket.projection.CustomOrder;

@RepositoryRestResource(path = "order",excerptProjection = CustomOrder.class)
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
