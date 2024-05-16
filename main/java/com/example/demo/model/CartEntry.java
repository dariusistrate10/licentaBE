package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@ToString
@Entity
@Table(name = "cart_entry")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = CartEntry.class)
public class CartEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long quantity;

//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(
//            name = "product_id",
//            referencedColumnName = "id"
//    )
//    private Product product;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "product_id",
            referencedColumnName = "id"
    )
    private List<Product> products = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "product_variant_id",
            referencedColumnName = "id"
    )
    private List<ProductVariant> productVariants = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "cart_id",
            referencedColumnName = "id"
    )
    private Cart cart;
}
