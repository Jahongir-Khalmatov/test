package lesson2.hometask2_pcmarket.projection;

import lesson2.hometask2_pcmarket.entity.Category;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Category.class)
public interface CustomCategory {
     String getNameUz();
     String getNameRu();
     String getNameEng();
     Category getCategory();
}
