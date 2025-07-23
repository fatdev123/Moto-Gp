package com.datn.moto_gp.modules.enumsdata.service;

import com.datn.moto_gp.constants.ErrorCode;
import com.datn.moto_gp.exception.AppException;
import com.datn.moto_gp.modules.enumsdata.dto.request.SessionTypeCreationRequest;
import com.datn.moto_gp.modules.enumsdata.dto.request.SessionTypeUpdateRequest;
import com.datn.moto_gp.modules.enumsdata.dto.response.SessionTypeResponse;
import com.datn.moto_gp.modules.enumsdata.entity.SessionType;
import com.datn.moto_gp.modules.enumsdata.entity.StatusType;
import com.datn.moto_gp.modules.enumsdata.mapper.SessionTypeMapper;
import com.datn.moto_gp.modules.enumsdata.repository.SessionTypeRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class SessionTypeService {
    SessionTypeRepository sessionTypeRepository;
    SessionTypeMapper sessionTypeMapper;

    public SessionType createSessionType(SessionTypeCreationRequest request){
        if(sessionTypeRepository.existsByCode(request.getCode()))
            throw new AppException(ErrorCode.SESSION_TYPE_ALREADY_EXISTS);
        SessionType sessionType = sessionTypeMapper.toSessionType(request);
        return sessionTypeRepository.save(sessionType);
    }

    public List<SessionType> getSessionTypes(){
        return sessionTypeRepository.findAll();
    }

    public SessionTypeResponse getSessionType(Integer id){
        return sessionTypeMapper.toSessionTypeResponse(sessionTypeRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.SESSION_TYPE_NOT_FOUND)));
    }

    public SessionTypeResponse updateSessionType(Integer id, SessionTypeUpdateRequest request){
        SessionType sessionType = sessionTypeRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.SESSION_TYPE_NOT_FOUND));
        sessionTypeMapper.updateSessionType(sessionType, request);
        return sessionTypeMapper.toSessionTypeResponse(sessionTypeRepository.save(sessionType));
    }

    public void deleteSessionType(Integer id){
        SessionType sessionType = sessionTypeRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.SESSION_TYPE_NOT_FOUND));
                sessionTypeRepository.deleteById(id);
    }

}
