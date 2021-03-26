package lesson2.data_rest.projection;

import lesson2.data_rest.entity.Client;
import lesson2.data_rest.entity.Currency;
import lesson2.data_rest.entity.Output;
import lesson2.data_rest.entity.WearHouse;
import org.springframework.data.rest.core.config.Projection;

import java.sql.Timestamp;

@Projection(types = Output.class)
public interface CustomOutput {
    Integer getId();
    Timestamp getTime();
    WearHouse getWearHouse();
    Client getClient();
    Currency getCurrency();
    String getFactureNumber();
    String getCode();
}
