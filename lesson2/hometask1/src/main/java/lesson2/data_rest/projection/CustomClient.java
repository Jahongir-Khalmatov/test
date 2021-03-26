package lesson2.data_rest.projection;

import lesson2.data_rest.entity.Client;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Client.class)
public interface CustomClient {
    Integer getId();
    String getName();
    boolean isActive();
    String getPhoneNumber();
}
