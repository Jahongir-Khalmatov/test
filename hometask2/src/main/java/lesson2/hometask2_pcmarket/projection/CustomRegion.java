package lesson2.hometask2_pcmarket.projection;

import lesson2.hometask2_pcmarket.entity.Region;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Region.class)
public interface CustomRegion {
    Integer getId();
    String getName();

}
