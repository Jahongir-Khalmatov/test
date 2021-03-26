package lesson2.data_rest.projection;

import lesson2.data_rest.entity.Attachment;
import lesson2.data_rest.entity.Category;
import lesson2.data_rest.entity.Measurement;
import lesson2.data_rest.entity.Product;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Product.class)
public interface CustomProduct {
    Integer getId();
    String getName();
    boolean isActive();
    Category getCategory();
    Attachment getPhoto();
    String getCode();
    Measurement getMeasurement();

}
