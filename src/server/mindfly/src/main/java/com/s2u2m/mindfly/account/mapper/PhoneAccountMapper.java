package com.s2u2m.mindfly.account.mapper;

import com.s2u2m.mindfly.account.entity.PhoneAccountEntity;
import org.apache.ibatis.annotations.Mapper;


public interface PhoneAccountMapper {
   int insert(PhoneAccountEntity record);
}