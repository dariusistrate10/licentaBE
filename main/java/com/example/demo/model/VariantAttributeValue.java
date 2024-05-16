package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "variant_attribute_value")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = VariantAttributeValue.class)
public class VariantAttributeValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String value;
    @Column
    private String name;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(
//            name = "product_variant_attribute_id",
//            referencedColumnName = "id"
//    )
//    @JsonIgnore
//    private ProductVariantAttribute productVariantAttribute;

    @OneToMany(mappedBy = "variantAttributeValue")
    @JsonIgnore
    private List<ProductVariantAttribute> productVariantAttributes;
}
