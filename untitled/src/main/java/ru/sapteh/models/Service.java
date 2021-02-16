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
@Table (name = "service")
public class Service {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String title;
    @Column
    private String cost;
    @Column
    private String durationInSecond;
    @Column
    private String description;
    @Column
    private String discount;
    @Column
    private String mainImagePath;

    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "service")
    @JoinColumn (name = "Service_ID")
    private Set<Clientservice> clientserviceSet;

    @OneToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "service")
    @JoinColumn (name = "Service_ID")
    private Set<Servicephoto> servicephotos;

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cost='" + cost + '\'' +
                ", durationInSecond='" + durationInSecond + '\'' +
                ", description='" + description + '\'' +
                ", discount='" + discount + '\'' +
                ", mainImagePath='" + mainImagePath + '\'' +
                '}';
    }
}
