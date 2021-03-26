package lesson2.data_rest.repository;

import lesson2.data_rest.entity.Supplier;
import lesson2.data_rest.projection.CustomSupplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "supplier",excerptProjection = CustomSupplier.class)

public interface SupplierRepository extends JpaRepository<Supplier,Integer> {

boolean existsByPhoneNumber(String phoneNumber);
}
