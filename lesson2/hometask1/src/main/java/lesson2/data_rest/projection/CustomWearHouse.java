package lesson2.data_rest.projection;

import lesson2.data_rest.entity.WearHouse;
import lesson2.data_rest.entity.template.AbsEntity;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = WearHouse.class)
public interface CustomWearHouse {
Integer getId();
String getName();
boolean isActive();

}
