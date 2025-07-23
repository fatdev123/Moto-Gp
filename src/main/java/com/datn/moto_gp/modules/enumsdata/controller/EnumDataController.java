package com.datn.moto_gp.modules.enumsdata.controller;

import com.datn.moto_gp.common.reponse.ApiResponse;
import com.datn.moto_gp.modules.enumsdata.dto.request.SessionTypeCreationRequest;
import com.datn.moto_gp.modules.enumsdata.dto.request.SessionTypeUpdateRequest;
import com.datn.moto_gp.modules.enumsdata.dto.request.StatusTypeCreationRequest;
import com.datn.moto_gp.modules.enumsdata.dto.request.StatusTypeUpdateRequest;
import com.datn.moto_gp.modules.enumsdata.dto.response.SessionTypeResponse;
import com.datn.moto_gp.modules.enumsdata.dto.response.StatusTypeResponse;
import com.datn.moto_gp.modules.enumsdata.entity.SessionType;
import com.datn.moto_gp.modules.enumsdata.entity.StatusType;
import com.datn.moto_gp.modules.enumsdata.service.SessionTypeService;
import com.datn.moto_gp.modules.enumsdata.service.StatusTypeService;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("enumdata")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EnumDataController {
    StatusTypeService statusTypeService;
    SessionTypeService sessionTypeService;


    //    status_type //

    @PostMapping("/status_type")
    ApiResponse<StatusType> createStatusType(@RequestBody StatusTypeCreationRequest request){
        ApiResponse<StatusType> apiResponse= new ApiResponse<>();
        apiResponse.setResult(statusTypeService.createStatusType(request));
        return apiResponse;
    }

    @GetMapping("/status_type")
    List<StatusType> getStatusTypes(){return statusTypeService.getStatusTypes();}

    @GetMapping("/status_type/{status_type_id}")
    StatusTypeResponse getStatusType(@PathVariable("status_type_id") Integer status_type_id){
        return statusTypeService.getStatusType(status_type_id);
    }

    @PutMapping("/status_type/{status_type_id}")
    StatusTypeResponse updateStatusType(@PathVariable("status_type_id") Integer id,@RequestBody StatusTypeUpdateRequest request){
        return statusTypeService.updateStatusType(id, request);
    }

    @DeleteMapping("/status_type/{status_type_id}")
    String deleteStatusType(@PathVariable("status_type_id") Integer id){
        statusTypeService.deleteStatusType(id);
        return "Status type has been deleted";
    }


    //    session_type //

    @PostMapping("/session_type")
    ApiResponse<SessionType> createSessionType(@RequestBody SessionTypeCreationRequest request){
        ApiResponse<SessionType> apiResponse = new ApiResponse<>();
        apiResponse.setResult(sessionTypeService.createSessionType(request));
        return apiResponse;
    }

    @GetMapping("/session_type")
    List<SessionType> getSessionTypes(){
        return sessionTypeService.getSessionTypes();
    }

    @GetMapping("/session_type/{session_type_id}")
    SessionTypeResponse getSessionType(@PathVariable("session_type_id") Integer id){
        return sessionTypeService.getSessionType(id);
    }

    @PutMapping("/session_type/{session_type_id}")
    SessionTypeResponse updateSessionType(@PathVariable("session_type_id") Integer id,@RequestBody SessionTypeUpdateRequest request){
        return sessionTypeService.updateSessionType(id, request);
    }

    @DeleteMapping("/session_type/{session_type_id}")
    String deleteSessionType(@PathVariable("session_type_id") Integer id){
        sessionTypeService.deleteSessionType(id);
        return "Session type has been deleted";
    }

}
