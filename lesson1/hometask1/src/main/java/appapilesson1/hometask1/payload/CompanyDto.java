package appapilesson1.hometask1.payload;

import appapilesson1.hometask1.entity.Address;
import lombok.Data;

import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Data
public class CompanyDto {
    @NotNull
    private Integer id;
    @NotNull(message = "corpName should not be empty")
    private String corpName;
    @NotNull(message = "directorName should not be empty")
    private String directorName;
    @NotNull(message = "addressId should not be empty")
    private Integer addressId;
    private String street;
    private Integer homeNumber;
}
