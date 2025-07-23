package com.datn.moto_gp.modules.merchandise.entity;

import com.datn.moto_gp.modules.enumsdata.entity.StatusType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@Table(name = "merchandise")
@NoArgsConstructor
@AllArgsConstructor
public class Merchandise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "product_id")
    private Long productId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false, foreignKey = @ForeignKey(name = "fk_merchandise_category"))
    private MerchCategory category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", nullable = false, foreignKey = @ForeignKey(name = "fk_merchandise_brand"))
    private MerchBrand brand;

    @Column (name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "stock", nullable = false)
    private int stock;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private StatusType status;

    // Quan hệ 1-n
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MerchProductVariant> variants;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MerchProductImage> images;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MerchProductAttribute> attributes;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MerchProductTeam> productTeams;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MerchProductRider> productRiders;
}
