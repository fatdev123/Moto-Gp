package com.datn.moto_gp.modules.enumsdata.mapper;

import com.datn.moto_gp.modules.enumsdata.dto.request.StatusTypeCreationRequest;
import com.datn.moto_gp.modules.enumsdata.dto.request.StatusTypeUpdateRequest;
import com.datn.moto_gp.modules.enumsdata.dto.response.StatusTypeResponse;
import com.datn.moto_gp.modules.enumsdata.entity.StatusType;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface StatusTypeMapper {
    StatusType toStatusType(StatusTypeCreationRequest request);
    StatusTypeResponse toStatusTypeResponse(StatusType statusType);
    void updateUser(@MappingTarget StatusType statusType, StatusTypeUpdateRequest request);
}
