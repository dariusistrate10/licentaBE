package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@Table(name = "product")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Product.class)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private Float price;
    @Column
    private Integer quantity;
    @Column
    private LocalDate addedDate;
    @Column
    private String photoUrl;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "product_category",
            joinColumns = @JoinColumn(
                    name = "product_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "category_id",
                    referencedColumnName = "id"
            )
    )
//    @JsonManagedReference
    private List<Category> categories;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "product_product_attribute",
            joinColumns = @JoinColumn(
                    name = "product_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "product_attribute_id",
                    referencedColumnName = "id"
            )
    )
//    @JsonManagedReference
    private List<ProductAttribute> productAttributes;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "product_product_value",
            joinColumns = @JoinColumn(
                    name = "product_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "product_value_id",
                    referencedColumnName = "id"
            )
    )
//    @JsonManagedReference
    private List<ProductValue> productValues;

//    @OneToOne(mappedBy = "product")
//    private CartEntry cartEntry;

    @ManyToMany(mappedBy = "products")
    @JsonBackReference
    private List<CartEntry> cartEntries;
}
