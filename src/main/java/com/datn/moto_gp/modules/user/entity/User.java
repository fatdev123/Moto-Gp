package com.datn.moto_gp.modules.user.entity;

import com.datn.moto_gp.modules.enumsdata.entity.StatusType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;


@Entity
@Data
@Table (name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "user_id")
    private Long id;

    @Column (name = "username")
    private String username;

    @Column (name = "password_hash")
    private String passwordHash;

    @Column (name = "email")
    private String email;

    @Column (name = "full_name")
    private String fullName;

    //@ManyToMany(fetch = FetchType.EAGER)
    //private Role role

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    private StatusType status;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
