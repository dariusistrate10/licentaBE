package com.example.demo.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "orders")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Orders.class)
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String paymentType;
    @Column
    private String deliveryAddress;
    @Column
    private String invoiceAddress;
    @Column
    private Long totalPrice;
    @Column
    private LocalDate orderDate;

//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(
//            name = "user_id",
//            referencedColumnName = "id"
//    )
//    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id"
    )
    private User user;

//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(
//            name = "cart_id",
//            referencedColumnName = "id"
//    )
//    private Cart cart;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "cart_id",
            referencedColumnName = "id"
    )
    private Cart cart;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "payment_id",
            referencedColumnName = "id"
    )
    private Payment payment;
}
