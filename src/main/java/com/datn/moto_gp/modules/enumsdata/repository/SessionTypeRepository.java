package com.datn.moto_gp.modules.enumsdata.repository;


import com.datn.moto_gp.modules.enumsdata.entity.SessionType;
import com.datn.moto_gp.modules.enumsdata.entity.StatusType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SessionTypeRepository extends JpaRepository<SessionType, Integer> {

    boolean existsByCode(String code);
    Optional<SessionType> findByCode(String code);
}
