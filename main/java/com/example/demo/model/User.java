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
@Table(name = "user")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = User.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String email;
    @Column
    private String phoneNumber;
    @Column
    private String password;
    @Column
    private String defaultDeliveryAddress;
    @Column
    private String defaultBillingAddress;
    @Column
    private String role;

    //    @JsonIgnore
    @JsonIgnoreProperties("user")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_address",
            joinColumns = @JoinColumn(
                    name = "user_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "address_id",
                    referencedColumnName = "id"
            )
    )
//    @JsonManagedReference
    private List<Address> addresses;

    @OneToOne(mappedBy = "user")
    private Cart cart;

//    @OneToOne(mappedBy = "user")
//    private Orders orders;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Orders> orders;
}
