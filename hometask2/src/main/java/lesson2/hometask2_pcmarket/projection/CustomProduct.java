package lesson2.hometask2_pcmarket.projection;

import lesson2.hometask2_pcmarket.entity.Attachment;
import lesson2.hometask2_pcmarket.entity.Category;
import lesson2.hometask2_pcmarket.entity.Product;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Product.class)
public interface CustomProduct {
     Integer getId();

     String getName();

     String getModel();

     String getDescription();

     Attachment getAttachment();

     float getPrice();

     Category getCategory();

     boolean isActive();
}
