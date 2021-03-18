package appapilesson1.hometask1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"street" , "homenumber"})})
public class Address {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
private String street;
private Integer homeNumber;

}
