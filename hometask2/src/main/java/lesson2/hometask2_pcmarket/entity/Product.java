package lesson2.hometask2_pcmarket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    private String model;

    private String description;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private Attachment attachment;

    private float price;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private Category category;

    private boolean active = true;
}
