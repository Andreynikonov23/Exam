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
@Table (name = "gender")
public class Gender {
    @Column
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private String code;
    @Column
    private String name;

    @OneToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn (name = "GenderCode")
    private Set<Client> clientSet;

    @Override
    public String toString() {
        return "Gender{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
