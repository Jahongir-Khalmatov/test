package realproject.lesson11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import realproject.lesson11.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier,Integer> {

boolean existsByPhoneNumber(String phoneNumber);
}
