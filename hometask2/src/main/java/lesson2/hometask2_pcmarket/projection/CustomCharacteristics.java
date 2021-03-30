package lesson2.hometask2_pcmarket.projection;

import lesson2.hometask2_pcmarket.entity.Charachteristics;
import lesson2.hometask2_pcmarket.entity.Product;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Charachteristics.class)
public interface CustomCharacteristics {
     Integer getId();

     String getName();

     Integer getSize();

     Product getProduct();
}
