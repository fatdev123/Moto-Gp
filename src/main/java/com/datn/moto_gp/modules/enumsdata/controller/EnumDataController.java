package com.datn.moto_gp.modules.enumsdata.controller;

import com.datn.moto_gp.common.reponse.ApiResponse;
import com.datn.moto_gp.modules.enumsdata.dto.request.StatusTypeCreationRequest;
import com.datn.moto_gp.modules.enumsdata.dto.response.StatusTypeResponse;
import com.datn.moto_gp.modules.enumsdata.entity.StatusType;
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

    //    status_type //

    StatusTypeService statusTypeService;

    @PostMapping("/status_type")
    ApiResponse<StatusType> createUser(@RequestBody StatusTypeCreationRequest request){
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




}
