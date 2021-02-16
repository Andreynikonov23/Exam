package ru.sapteh.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table (name = "product")
public class Product {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String title;
    @Column
    private String cost;
    @Column
    private String description;
    @Column
    private String mainImagePath;
    @Column
    private String isActive;

    @OneToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product")
    @JoinColumn (name = "Product_ID")
    private Set<Productsale> productsales;

    @OneToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product")
    @JoinColumn (name = "Product_ID")
    private Set<Productphoto> productphotos;

    @OneToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Manufacturer> manufacturers;

    @OneToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product")
    @JoinColumn (name = "MainProduct_ID")
    @JoinColumn (name = "AttachedProduct_ID")
    private Set<Attacheadproduct> attacheadproducts;


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cost='" + cost + '\'' +
                ", description='" + description + '\'' +
                ", mainImagePath='" + mainImagePath + '\'' +
                ", isActive='" + isActive + '\'' +
                '}';
    }
}
