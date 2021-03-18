package realproject.lesson11.payload;

import lombok.Data;
import realproject.lesson11.entity.Currency;
import realproject.lesson11.entity.Supplier;
import realproject.lesson11.entity.WearHouse;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@Data

public class InputDto {
    private Integer id;
    private Timestamp date;
    private Integer wearHouseId;
    private Integer supplierId;
    private Integer currencyId;
    private String  factureNumber;
    private String code;
}
