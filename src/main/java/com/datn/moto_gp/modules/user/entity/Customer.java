package com.datn.moto_gp.modules.user.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "customers")
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "customer_id")
    private Long id;

    @Column (name = "full_name", length = 50, nullable = false)
    private String fullName;

    @Column (name = "phone", length = 15, nullable = false)
    private String phone;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column (name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;

}
