package lesson2.data_rest.projection;

import lesson2.data_rest.entity.Category;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Category.class)
public interface CustomCategory {
    Integer getId();
    String getName();
    boolean isActive();
    Category getParenCategory();
}
