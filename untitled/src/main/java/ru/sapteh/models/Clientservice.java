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
@Table (name = "clientservice")
public class Clientservice {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String startTime;
    @Column
    private String comment;

    @ManyToOne (cascade = CascadeType.ALL)
    private Set<Client> clientSet;

    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Service> services;

    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "clientservice")
    @JoinColumn (name = "Clientservice_ID")
    private Set<Documentbyservice> documentbyservices;

    @Override
    public String toString() {
        return "Clientservice{" +
                "id=" + id +
                ", startTime='" + startTime + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
