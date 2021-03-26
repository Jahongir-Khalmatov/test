package lesson2.data_rest.projection;

import lesson2.data_rest.entity.Currency;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Currency.class)
public interface CustomCurrency {
    Integer getId();
    String getName();
    boolean isActive();
}
