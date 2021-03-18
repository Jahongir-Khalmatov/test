package appapilesson1.hometask1.repository;

import appapilesson1.hometask1.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {

boolean existsByStreetAndHomeNumber(String street, Integer homeNumber);
boolean existsByStreetAndHomeNumberAndIdNot(String street, Integer homeNumber, Integer id);

}
