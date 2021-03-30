package lesson2.hometask2_pcmarket.projection;

import lesson2.hometask2_pcmarket.entity.Comments;
import lesson2.hometask2_pcmarket.entity.Product;
import lesson2.hometask2_pcmarket.entity.User;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Comments.class)
public interface CustomComment {
     Integer getId();

     String getBody();

     User getUser();

     Product getProduct();

     Integer getNumberStars();
}
