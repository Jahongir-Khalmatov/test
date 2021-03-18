package realproject.lesson11.payload;

import lombok.Data;

import java.util.Date;

@Data
public class OutputProductDto {
    private Integer id;
    private Integer productId;
    private Integer amount;
    private String price;
    private Integer outputId;

}
