package appapilesson1.hometask1.payload;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddressDto {
    private Integer id;
@NotNull(message = " the street should not be empty")
    private String street;
    @NotNull(message = " the homeNumber should not be empty")
    private Integer homeNumber;
}
