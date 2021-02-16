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
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String title;
    @Column
    private String color;

    @ManyToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "tag")
    @JoinColumn (name = "Tag_ID")
    private Set<Tagofclient> tagofclientSet;


    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
