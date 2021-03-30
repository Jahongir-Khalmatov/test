package lesson2.hometask2_pcmarket.projection;

import lesson2.hometask2_pcmarket.entity.OutputProduct;
import lesson2.hometask2_pcmarket.entity.Product;
import org.springframework.data.rest.core.config.Projection;

import java.util.Set;

@Projection(types = OutputProduct.class)
public interface CustomOutputProduct {
    Integer getId();
     Set<Product> getProduct();

     Integer getAmount();
}
