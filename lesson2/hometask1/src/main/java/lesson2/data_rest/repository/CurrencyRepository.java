package lesson2.data_rest.repository;

import lesson2.data_rest.entity.Currency;
import lesson2.data_rest.projection.CustomCurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "currency",excerptProjection = CustomCurrency.class)

public interface CurrencyRepository extends JpaRepository<Currency,Integer> {
    boolean existsByName(String name);
}
