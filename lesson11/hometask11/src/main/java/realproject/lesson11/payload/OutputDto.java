package realproject.lesson11.payload;

import lombok.Data;

import java.sql.Timestamp;

@Data

public class OutputDto {
    private Integer id;
    private Timestamp date;
    private Integer wearHouseId;
    private Integer currencyId;
    private String  factureNumber;
    private Integer  clientId;
    private String code;
}
