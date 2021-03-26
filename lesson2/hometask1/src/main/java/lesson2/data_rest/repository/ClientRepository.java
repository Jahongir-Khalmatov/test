package lesson2.data_rest.repository;

import lesson2.data_rest.entity.Client;
import lesson2.data_rest.projection.CustomClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "client",excerptProjection = CustomClient.class)

public interface ClientRepository extends JpaRepository<Client,Integer> {
    boolean existsByPhoneNumber(String phoneNumber);
}
