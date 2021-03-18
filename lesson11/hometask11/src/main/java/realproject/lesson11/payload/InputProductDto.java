package realproject.lesson11.payload;

import lombok.Data;
import realproject.lesson11.entity.Input;
import realproject.lesson11.entity.Product;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data
public class InputProductDto {
    private Integer id;
    private Integer productId;
    private Integer amount;
    private String price;
    private Date expireDate;
    private Integer inputId;

}
