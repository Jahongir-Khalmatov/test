package lesson2.hometask2_pcmarket.projection;

import lesson2.hometask2_pcmarket.entity.Order;
import lesson2.hometask2_pcmarket.entity.UserBasket;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Order.class)
public interface CustomOrder {
     Integer getId();

     String getDate();

     UserBasket getUserBasket();

     String getDetails();
}
