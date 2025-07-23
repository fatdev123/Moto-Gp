package com.datn.moto_gp.modules.user.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "admins")
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "admin_id")
    private Long id;

    @Column (name = "full_name", length = 50, nullable = false)
    private String fullName;

    @Column (name = "phone", length = 15, nullable = false)
    private String phone;

    @Column (name = "last_password_change", nullable = false)
    private LocalDate lastPasswordChange;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;

}
