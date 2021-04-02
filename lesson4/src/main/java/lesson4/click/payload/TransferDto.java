package lesson4.click.payload;

import lombok.Data;

@Data
public class TransferDto {
private Integer id;
private String  toCardId;
private String  fromCardId;
private Double amount;
}
