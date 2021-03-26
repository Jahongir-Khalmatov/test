package lesson2.data_rest.projection;

import lesson2.data_rest.entity.Users;
import lesson2.data_rest.entity.WearHouse;
import org.springframework.data.rest.core.config.Projection;

import java.util.Set;

@Projection(types = Users.class)
public interface CustomUser {
    Integer getId();
    String getFirstName();
    String getLastName();
    String getPhoneNumber();
    String getPassword();
    String getCode();
    boolean  isActive();
    Set<WearHouse> getWearHouse();
}
