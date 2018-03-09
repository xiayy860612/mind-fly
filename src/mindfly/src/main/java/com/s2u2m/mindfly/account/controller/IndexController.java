package com.s2u2m.mindfly.account.controller;

import com.s2u2m.mindfly.account.mapper.UserInfoEntity;
import com.s2u2m.mindfly.account.mapper.UserInfoEntityMapper;
import com.s2u2m.mindfly.core.uid.SnowFlakeUidProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.s2u2m.mindfly.core.serialization.Response;
import com.s2u2m.mindfly.account.dto.IndexRespDTO;

@RestController
public class IndexController {

    @Autowired
    UserInfoEntityMapper mapper;

//    @Autowired
//    SnowFlakeUidGenerator generator;

    @Autowired
    SnowFlakeUidProperty property;

    @GetMapping(path = "/")
    public Response<IndexRespDTO> index() throws Exception{
        UserInfoEntity entity = new UserInfoEntity();
        entity.setId("123");
        entity.setNickName("hello");

        int rst = mapper.insert(entity);

//        throw  new ExceptionBuilder<IndexErrorCode>().setErrCode(IndexErrorCode.Unknown).build();

        IndexRespDTO data = IndexRespDTO.builder()
                .msg("hello world")
                .entity(entity)
                .build();
        return new Response<IndexRespDTO>().setData(data);
    }
}
