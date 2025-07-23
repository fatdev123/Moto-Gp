package com.datn.moto_gp.modules.enumsdata.service;

import com.datn.moto_gp.constants.ErrorCode;
import com.datn.moto_gp.exception.AppException;
import com.datn.moto_gp.modules.enumsdata.dto.request.StatusTypeCreationRequest;
import com.datn.moto_gp.modules.enumsdata.dto.request.StatusTypeUpdateRequest;
import com.datn.moto_gp.modules.enumsdata.dto.response.StatusTypeResponse;
import com.datn.moto_gp.modules.enumsdata.entity.StatusType;
import com.datn.moto_gp.modules.enumsdata.mapper.StatusTypeMapper;
import com.datn.moto_gp.modules.enumsdata.repository.StatusTypeRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StatusTypeService {
    StatusTypeRepository statusTypeRepository;
    StatusTypeMapper statusTypeMapper;
    public StatusType createStatusType(StatusTypeCreationRequest request){
        if(statusTypeRepository.existsByCode(request.getCode()))
            throw new AppException(ErrorCode.STATUS_TYPE_ALREADY_EXISTS);
        StatusType statusType = statusTypeMapper.toStatusType(request);
        return statusTypeRepository.save(statusType);
    }

    public List<StatusType> getStatusTypes(){return statusTypeRepository.findAll();}

    public StatusTypeResponse getStatusType(Integer id){
        return statusTypeMapper.toStatusTypeResponse(statusTypeRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.SESSION_TYPE_NOT_FOUND)));
    }

    public StatusTypeResponse updateStatusType(Integer id, StatusTypeUpdateRequest request){
        StatusType statusType = statusTypeRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.STATUS_TYPE_NOT_FOUND));
        statusTypeMapper.updateStatusType(statusType, request);
        return statusTypeMapper.toStatusTypeResponse(statusTypeRepository.save(statusType));
    }

    public void deleteStatusType(Integer id){
        StatusType statusType = statusTypeRepository.findById(id)
                        .orElseThrow(() -> new AppException(ErrorCode.STATUS_TYPE_NOT_FOUND));
        statusTypeRepository.deleteById(id);
    }

}
