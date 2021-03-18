package realproject.lesson11.payload;

import lombok.Data;
import realproject.lesson11.entity.Attachment;
import realproject.lesson11.entity.Category;
import realproject.lesson11.entity.Measurement;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Data
public class ProductDto {
    private Integer categoryId;
    private Integer photoId;
    private String code;
    private Integer measurementId;
}
