package ru.sapteh.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "productphoto")
public class Productphoto {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String photoPath;

    @OneToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Product> productSet;

    @Override
    public String toString() {
        return "Productphoto{" +
                "id=" + id +
                ", photoPath='" + photoPath + '\'' +
                '}';
    }
}
