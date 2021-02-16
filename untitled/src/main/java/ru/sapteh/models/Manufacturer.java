package ru.sapteh.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "manufacturer")
public class Manufacturer {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String startDate;

    @OneToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "manufacturer")
    @JoinColumn (name = "Manufacturer_ID")
    private Set<Product> productSet;

    @Override
    public String toString() {
        return "Manufacturer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startDate='" + startDate + '\'' +
                '}';
    }
}
