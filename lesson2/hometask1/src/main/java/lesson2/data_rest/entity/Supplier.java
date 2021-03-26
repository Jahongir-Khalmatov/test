package lesson2.data_rest.entity;

import lesson2.data_rest.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Supplier extends AbsEntity {
    @Column(unique = true,nullable = false)
    private String phoneNumber;
}
