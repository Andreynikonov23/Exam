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
@Table (name = "servicephoto")
public class Servicephoto {
    @Id
    private int id;
    @Column
    private String photoPath;

    @OneToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Service> serviceSet;

    @Override
    public String toString() {
        return "Servicephoto{" +
                "id=" + id +
                ", photoPath='" + photoPath + '\'' +
                '}';
    }
}
