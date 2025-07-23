package com.datn.moto_gp.modules.user.entity;

import com.datn.moto_gp.modules.merchandise.entity.Merchandise;
import com.datn.moto_gp.modules.ticket.entity.Ticket;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "sellers")
@NoArgsConstructor
@AllArgsConstructor
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "seller_id")
    private Long id;

    @Column (name = "full_name", length = 50, nullable = false)
    private String fullName;

    @Column (name = "phone", length = 15, nullable = false)
    private String phone;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;

    // Một seller quản lý nhiều ticket
    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ticket> tickets;

    // Một seller quản lý nhiều merchandise
    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Merchandise> merchandiseList;

}
