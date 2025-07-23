package com.datn.moto_gp.modules.merchandise.entity;

import com.datn.moto_gp.modules.enumsdata.entity.StatusType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "merch_categories")
@NoArgsConstructor
@AllArgsConstructor
public class MerchCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    // Danh mục cha (self-referencing)
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private MerchCategory parent;

    // Trạng thái (Active, Inactive, etc.)
    @ManyToOne
    @JoinColumn(name = "status_id")
    private StatusType status;


    // Danh sách con (self-referencing)
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MerchCategory> children;
}
