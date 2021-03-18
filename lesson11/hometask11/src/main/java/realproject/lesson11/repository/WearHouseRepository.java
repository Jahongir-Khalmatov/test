package realproject.lesson11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import realproject.lesson11.entity.WearHouse;

public interface WearHouseRepository extends JpaRepository<WearHouse,Integer> {
    boolean existsByName(String name);
}
