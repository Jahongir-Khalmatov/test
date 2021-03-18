package realproject.lesson11.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import realproject.lesson11.entity.WearHouse;

import javax.persistence.*;
import java.util.Set;

@Data
public class UsersDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String password;
    private String code;
    private boolean active;
    private Set<Integer> wearHousesId;



}
