package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@ToString
@Entity
@Table(name = "product_variant")
public class ProductVariant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private Long price;
    @Column
    private Long quantity;
    @Column
    private LocalDate addedDate;
    @Column
    private String photoUrl;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "product_id",
            referencedColumnName = "id"
    )
    private ProductCore productCore;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "category_variant_id",
            referencedColumnName = "id"
    )
    private CategoryVariant categoryVariant;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "attribute_variant_id",
            referencedColumnName = "id"
    )
    private AttributeVariant attributeVariant;

    @ManyToMany(mappedBy = "productVariants")
    @JsonBackReference
    private List<CartEntry> cartEntries;

    @OneToMany(mappedBy = "productVariant", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Review> reviews = new ArrayList<>();
}
