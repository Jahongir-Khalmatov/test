package lesson2.data_rest.projection;

import lesson2.data_rest.entity.Output;
import lesson2.data_rest.entity.OutputProduct;
import lesson2.data_rest.entity.Product;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = OutputProduct.class)
public interface CustomOutputProduct {
    Integer getId();
    Product getProduct();
    Integer getAmount();
    String getPrice();
    Output getOutput();
}
