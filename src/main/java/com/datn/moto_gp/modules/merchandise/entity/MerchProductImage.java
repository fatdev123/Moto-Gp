package com.datn.moto_gp.modules.merchandise.entity;

import com.datn.moto_gp.modules.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "merch_product_images")
@NoArgsConstructor
@AllArgsConstructor
public class MerchProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long imageId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Merchandise product;

    @Column(name = "image_url", nullable = false, columnDefinition = "TEXT")
    private String imageUrl;

    @Column(name = "is_main", nullable = false)
    private boolean isMain = false;

    @Column(name = "caption")
    private String caption;

    @ManyToOne
    @JoinColumn(name = "uploaded_by")
    private User uploadedBy;

    @Column(name = "uploaded_at")
    private LocalDateTime uploadedAt = LocalDateTime.now();
}
