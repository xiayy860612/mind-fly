package com.s2u2m.mindfly.account.dto;

import com.s2u2m.mindfly.account.mapper.UserInfoEntity;
import com.s2u2m.mindfly.core.serialization.ResponseData;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class IndexRespDTO extends ResponseData {
    private String msg;
    private UserInfoEntity entity;
}
