package appapilesson1.hometask1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Worker {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
private String name;
private String phoneNumber;
@OneToOne
private Address address;
@ManyToOne
private Department department;
}
