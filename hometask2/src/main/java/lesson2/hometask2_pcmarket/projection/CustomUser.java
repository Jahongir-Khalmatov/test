package lesson2.hometask2_pcmarket.projection;

import lesson2.hometask2_pcmarket.entity.Address;
import lesson2.hometask2_pcmarket.entity.User;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = User.class)
public interface CustomUser {
     Integer getid();

     String getfullName();

     String getemail();

     String getpassword();

     Address getaddress();
}
