package lesson2.hometask2_pcmarket.projection;

import lesson2.hometask2_pcmarket.entity.OutputProduct;
import lesson2.hometask2_pcmarket.entity.User;
import lesson2.hometask2_pcmarket.entity.UserBasket;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = UserBasket.class)
public interface CustomUserBasket {
     Integer getid();

     OutputProduct getoutputProduct();

     float getallSum();

     User getuser();
}
