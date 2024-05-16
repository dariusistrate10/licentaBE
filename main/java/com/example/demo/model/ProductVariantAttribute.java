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
@Table(name = "product_variant_attribute")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = ProductVariantAttribute.class)
public class ProductVariantAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "attribute_variant_id",
            referencedColumnName = "id"
    )
    @JsonIgnore
    private AttributeVariant attributeVariant;

//    @OneToMany(mappedBy = "productVariantAttribute")
//    private List<VariantAttributeValue> variantAttributeValues;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "variant_attribute_value_id",
            referencedColumnName = "id"
    )
    private VariantAttributeValue variantAttributeValue;
}
