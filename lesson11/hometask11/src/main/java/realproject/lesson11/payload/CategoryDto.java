package realproject.lesson11.payload;

import lombok.Data;

@Data
public class CategoryDto {
    private Integer id;
    private String name;
    private boolean active;
    private Integer categoryId;
}
