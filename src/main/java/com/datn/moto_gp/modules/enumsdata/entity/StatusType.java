package com.datn.moto_gp.modules.enumsdata.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "status_type")
public class StatusType {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "status_id")
        int statusId;

        @Column(name = "code")
        String code;

        @Column(name = "name")
        String name;

        @Column(name = "description")
        String description;
}
