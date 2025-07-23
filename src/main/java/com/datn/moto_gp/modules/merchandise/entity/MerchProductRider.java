package com.datn.moto_gp.modules.merchandise.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "merch_products_riders")
@NoArgsConstructor
@AllArgsConstructor
public class MerchProductRider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "products_riders_id")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Merchandise product;

    @ManyToOne(optional = false)
    @JoinColumn(name = "rider_id", nullable = false)
    private Rider rider;
}
