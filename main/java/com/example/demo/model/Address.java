package com.example.demo.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "address")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Address.class)
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String streetLine;
    @Column
    private String postalCode;
    @Column
    private String city;
    @Column
    private String country;

    @ManyToMany(mappedBy = "addresses", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("addresses")
//    @JsonIgnore
    private List<User> users;

}
