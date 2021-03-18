package appapilesson1.hometask1.payload;

import appapilesson1.hometask1.entity.Department;
import lombok.Data;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Data
public class DepartmentDto {
    private Integer id;
    @NotNull(message = "name should not be empty")
    private String name;
    @NotNull(message = "companyId should not be empty")
    private Integer companyId;
}
