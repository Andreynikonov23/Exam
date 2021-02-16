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
@Table (name = "attacheadproduct")
public class Attacheadproduct {
    @OneToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Product> productSet;
}
