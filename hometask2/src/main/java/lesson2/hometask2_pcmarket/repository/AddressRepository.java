package lesson2.hometask2_pcmarket.repository;

import lesson2.hometask2_pcmarket.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import lesson2.hometask2_pcmarket.projection.CustomAddress;


@RepositoryRestResource(path = "address",excerptProjection = CustomAddress.class)
public interface AddressRepository extends JpaRepository<Address, Integer> {


}
