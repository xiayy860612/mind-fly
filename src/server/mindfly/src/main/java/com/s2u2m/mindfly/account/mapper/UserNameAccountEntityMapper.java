package com.s2u2m.mindfly.account.mapper;

import com.s2u2m.mindfly.account.entity.UserNameAccountEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface UserNameAccountEntityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table username_account
     *
     * @mbg.generated Mon Mar 12 11:44:19 CST 2018
     */
    int insert(UserNameAccountEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table username_account
     *
     * @mbg.generated Mon Mar 12 11:44:19 CST 2018
     */
    List<UserNameAccountEntity> selectAll();

    UserNameAccountEntity selectByUserName(String userName);
}