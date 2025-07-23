package com.datn.moto_gp.modules.merchandise.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "merch_product_variants")
@NoArgsConstructor
@AllArgsConstructor
public class MerchProductVariant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "variant_id")
    private Long variantId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Merchandise product;

    @Column(name = "size", length = 20)
    private String size;

    @Column(name = "stock", nullable = false)
    private int stock;

    @Column(name = "price", precision = 10, scale = 2, nullable = false)
    private BigDecimal price;
}
