package lesson2.data_rest.entity;

import lesson2.data_rest.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product extends AbsEntity {
    @ManyToOne
    private Category category;
    @OneToOne
private Attachment photo;
    @Column(unique = true,nullable = false)
    private String code;
    @ManyToOne
    private Measurement measurement;

}
