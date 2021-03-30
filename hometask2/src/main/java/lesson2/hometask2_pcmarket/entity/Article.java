package lesson2.hometask2_pcmarket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String description;

    private String urlLink;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private Attachment attachment;
}
