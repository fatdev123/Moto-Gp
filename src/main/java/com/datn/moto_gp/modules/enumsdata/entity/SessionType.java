package com.datn.moto_gp.modules.enumsdata.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Generated;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "session_types")
public class SessionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_type_id")
    int id;

    @Column(name = "code")
    String code;

    @Column(name="description")
    String description;
}
