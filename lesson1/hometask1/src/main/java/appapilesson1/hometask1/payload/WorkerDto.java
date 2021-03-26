package appapilesson1.hometask1.payload;

import appapilesson1.hometask1.entity.Address;
import appapilesson1.hometask1.entity.Department;
import lombok.Data;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Data
public class WorkerDto {
    private Integer id;
    @NotNull(message = "name should not be empty")
    private String name;
    @NotNull(message = "phoneNumber should not be empty")
    private String phoneNumber;
    private Integer addressId;
    @NotNull(message = "department should not be empty")
    private Integer departmentId;
    private String street;
    private Integer homeNumber;
}
