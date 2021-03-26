package appapilesson1.hometask1.repository;

import appapilesson1.hometask1.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Integer> {
}
