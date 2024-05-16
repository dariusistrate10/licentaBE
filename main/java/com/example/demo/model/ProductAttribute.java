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
@Table(name = "product_attribute")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = ProductAttribute.class)
public class ProductAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;

//    @JsonIgnore
    @ManyToMany(mappedBy = "productAttributes", fetch = FetchType.EAGER)
    @JsonBackReference(value = "productattribute_product")
    private List<Product> products;

    @OneToMany(mappedBy = "productAttribute")
//    @JsonManagedReference
    private List<AttributeValue> attributeValues;
}
