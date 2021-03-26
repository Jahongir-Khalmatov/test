package lesson2.data_rest.projection;

import lesson2.data_rest.entity.Measurement;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Measurement.class)
public interface CustomMeasurement {
Integer getId();
String getName();
boolean isActive();
}
