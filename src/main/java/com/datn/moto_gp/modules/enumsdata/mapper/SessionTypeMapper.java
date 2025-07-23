package com.datn.moto_gp.modules.enumsdata.mapper;

import com.datn.moto_gp.modules.enumsdata.dto.request.SessionTypeCreationRequest;
import com.datn.moto_gp.modules.enumsdata.dto.request.SessionTypeUpdateRequest;
import com.datn.moto_gp.modules.enumsdata.dto.response.SessionTypeResponse;
import com.datn.moto_gp.modules.enumsdata.entity.SessionType;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SessionTypeMapper {
    SessionType toSessionType(SessionTypeCreationRequest request);
    SessionTypeResponse toSessionTypeResponse(SessionType sessionType);
    void updateSessionType(@MappingTarget SessionType sessionType, SessionTypeUpdateRequest request);
}
