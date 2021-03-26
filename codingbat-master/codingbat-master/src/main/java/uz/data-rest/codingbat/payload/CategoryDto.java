package uz.raximov.codingbat.payload;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CategoryDto {

    @NotNull
    private String name;

    private String description;

    @NotNull
    private Integer proglangId;
}
