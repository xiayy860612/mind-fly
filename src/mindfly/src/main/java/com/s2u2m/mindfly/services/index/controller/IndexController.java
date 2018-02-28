package com.s2u2m.mindfly.services.index.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.s2u2m.mindfly.core.exception.ExceptionBuilder;
import com.s2u2m.mindfly.core.exception.MindFlyException;
import com.s2u2m.mindfly.core.serialization.Response;
import com.s2u2m.mindfly.services.index.DTO.IndexRespData;
import com.s2u2m.mindfly.services.index.IndexErrorCode;

@RestController
public class IndexController {


    @GetMapping(path = "/")
    public Response<IndexRespData> index() throws Exception{
        throw  new ExceptionBuilder<IndexErrorCode>().setErrCode(IndexErrorCode.Unknown).build();

//        IndexRespData data = IndexRespData.builder().msg("hello world").build();
//        return Response.<IndexRespData>builder()
//            .data(data).build();
    }
}
