package com.s2u2m.mindfly.account.mapper;

import com.s2u2m.mindfly.account.entity.UserInfoEntity;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoEntityMapperTest {

    @Autowired
    UserInfoEntityMapper mapper;

    @Ignore
    @Test
    public void insertUserInfo_success() {
        UserInfoEntity entity = new UserInfoEntity();
        entity.setId("123");
        entity.setNickName("hello");
        entity.setCreateTime(Date.from(Instant.now()));
        entity.setDeleteFlag((byte)0);

        int rst = mapper.insert(entity);

        assertTrue(rst == 1);
    }
}