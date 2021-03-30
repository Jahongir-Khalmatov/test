package lesson2.hometask2_pcmarket.projection;

import lesson2.hometask2_pcmarket.entity.District;
import lesson2.hometask2_pcmarket.entity.Region;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = District.class)
public interface CustomDistrict {
     Integer getId();

     String getName();

     Region getRegion();
}
