package lesson2.data_rest.projection;

import lesson2.data_rest.entity.Supplier;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Supplier.class)
public interface CustomSupplier {
    Integer getID();
    String getName();
    boolean isActive();
    String getPhoneNumber();
}
