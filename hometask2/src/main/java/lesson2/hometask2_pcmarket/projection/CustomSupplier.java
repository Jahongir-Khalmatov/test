package lesson2.hometask2_pcmarket.projection;

import lesson2.hometask2_pcmarket.entity.Supplier;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Supplier.class)
public interface CustomSupplier {
     Integer getId();

     String getfullName();

     String getemail();

     String getphoneNumber();

     String getmessageBody();
}
