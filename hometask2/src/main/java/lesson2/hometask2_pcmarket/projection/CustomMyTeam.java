package lesson2.hometask2_pcmarket.projection;

import lesson2.hometask2_pcmarket.entity.Attachment;
import lesson2.hometask2_pcmarket.entity.MyTeam;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = MyTeam.class)
public interface CustomMyTeam {
     Integer getId();

     String name();

     String getOccupation();

     Attachment getAttachment();
}
