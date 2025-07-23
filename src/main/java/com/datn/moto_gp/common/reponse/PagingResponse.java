package com.datn.moto_gp.common.reponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PagingResponse <T>{
    int page;
    int size;
    long totalElements;
    int totalPages;
    List<T> content;
}
