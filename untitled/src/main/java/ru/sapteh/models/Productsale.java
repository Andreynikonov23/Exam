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
@Table (name = "productsale")
public class Productsale {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String saleDate;
    @Column
    private String quantity;

    @OneToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Product> products;

    @Override
    public String toString() {
        return "Productsale{" +
                "id=" + id +
                ", saleDate='" + saleDate + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}
