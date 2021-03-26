package lesson2.data_rest.projection;

import lesson2.data_rest.entity.Input;
import lesson2.data_rest.entity.InputProduct;
import lesson2.data_rest.entity.Product;
import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(types = InputProduct.class)
public interface CustomInputProduct {
    Integer getId();
    Product getProduct();
    Integer getAmount();
    String getPrice();
    Date getDate();
    Input getInput();
}
