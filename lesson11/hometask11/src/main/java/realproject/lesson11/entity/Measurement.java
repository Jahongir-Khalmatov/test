package realproject.lesson11.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import realproject.lesson11.entity.template.AbsEntity;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Measurement extends AbsEntity {

}
