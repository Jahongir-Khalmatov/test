package lesson2.data_rest.repository;

import lesson2.data_rest.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "supplier")

public interface SupplierRepository extends JpaRepository<Supplier,Integer> {

boolean existsByPhoneNumber(String phoneNumber);
}
