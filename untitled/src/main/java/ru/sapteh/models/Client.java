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
@Table (name = "client")
public class Client {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String firstname;
    @Column
    private String lastname;
    @Column
    private String patronymic;
    @Column
    private String birthday;
    @Column
    private String registrationDate;
    @Column
    private String email;
    @Column
    private String phone;
    @Column
    private String photoPath;


    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn (name = "Client_ID")
    private Set<Clientservice> clientservices;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "client")
    @JoinColumn(name = "Client_ID")
    private Set<Tagofclient> tagofclients;

    @OneToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "client")
    private Set<Gender> genders;

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthday='" + birthday + '\'' +
                ", registrationDate='" + registrationDate + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", photoPath='" + photoPath + '\'' +
                '}';
    }
}
