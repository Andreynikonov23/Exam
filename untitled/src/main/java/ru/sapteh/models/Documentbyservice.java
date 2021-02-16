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
@Table (name = "documentbyservice")
public class Documentbyservice {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String documentPath;

    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Clientservice> clientserviceSet;

    @Override
    public String toString() {
        return "Documentbyservice{" +
                "id=" + id +
                ", documentPath='" + documentPath + '\'' +
                '}';
    }
}
