package com.datn.moto_gp.modules.enumsdata.repository;

import com.datn.moto_gp.modules.enumsdata.entity.StatusType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatusTypeRepository extends JpaRepository<StatusType, Integer> {
    boolean existsByCode(String code);
    Optional<StatusType> findByCode(String code);
}
