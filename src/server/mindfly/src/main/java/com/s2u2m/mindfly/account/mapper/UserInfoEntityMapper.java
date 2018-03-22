package com.s2u2m.mindfly.account.mapper;

import com.s2u2m.mindfly.account.entity.UserInfoEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface UserInfoEntityMapper {

    int insert(UserInfoEntity record);

    UserInfoEntity selectById(String id);

}