package appapilesson1.hometask1.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Company {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
private String corpName;
private String directorName;
@OneToOne
private Address address;
}
