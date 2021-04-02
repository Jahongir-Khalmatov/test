package lesson4.click.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Income {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
@ManyToOne
public Card fromCard;
@ManyToOne
public Card toCard;
public Double amount;
public Date date;
}
