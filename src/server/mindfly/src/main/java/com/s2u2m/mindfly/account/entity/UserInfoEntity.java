package com.s2u2m.mindfly.account.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

@Getter
@Setter
@Accessors(chain = true)
public class UserInfoEntity {
    private String id;
    private String nickName;
    private String password;
    private Date createTime;
    private Date updateTime;
    private Byte deleteFlag = 0;
}
