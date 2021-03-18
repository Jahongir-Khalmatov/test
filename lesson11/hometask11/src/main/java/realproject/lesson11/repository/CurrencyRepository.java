package realproject.lesson11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import realproject.lesson11.entity.Currency;

public interface CurrencyRepository extends JpaRepository<Currency,Integer> {
    boolean existsByName(String name);
}
