package lesson2.data_rest.projection;

import lesson2.data_rest.entity.*;
import org.springframework.data.rest.core.config.Projection;

import java.sql.Timestamp;
import java.util.Date;

@Projection(types = Input.class)
public interface CustomInput {
    Integer getId();
    Timestamp getDate();
    WearHouse getWearHouse();
    Supplier getSupplier();
    Currency getCurrency();
    String getFactureNumber();
    String getCode();


}
