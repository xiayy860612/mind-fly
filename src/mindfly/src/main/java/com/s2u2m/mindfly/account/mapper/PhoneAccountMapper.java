package com.s2u2m.mindfly.account.mapper;

import com.s2u2m.mindfly.account.mapper.PhoneAccount;
import java.util.List;

public interface PhoneAccountMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table phone_account
     *
     * @mbg.generated Mon Mar 12 11:44:19 CST 2018
     */
    int insert(PhoneAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table phone_account
     *
     * @mbg.generated Mon Mar 12 11:44:19 CST 2018
     */
    List<PhoneAccount> selectAll();
}