package lesson2.hometask2_pcmarket.projection;

import lesson2.hometask2_pcmarket.entity.Address;
import lesson2.hometask2_pcmarket.entity.District;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Address.class)
public interface CustomAddress {
     Integer getId();
     String getStreet();
     String getHomeNumber();
     District getDistrict();
}
