package com.datn.moto_gp.modules.merchandise.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "merch_product_attributes")
@NoArgsConstructor
@AllArgsConstructor
public class MerchProductAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Merchandise product;

    @Column(name = "attribute_type", nullable = false, length = 100)
    private String attributeType;

    @Column(name = "attribute_value", nullable = false, length = 255)
    private String attributeValue;
}
