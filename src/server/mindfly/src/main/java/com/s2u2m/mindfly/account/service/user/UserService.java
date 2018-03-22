package com.s2u2m.mindfly.account.service.user;

import com.s2u2m.mindfly.account.entity.UserInfoEntity;
import com.s2u2m.mindfly.account.mapper.UserInfoEntityMapper;
import com.s2u2m.mindfly.core.time.S2u2mTimer;
import com.s2u2m.mindfly.core.uid.SnowFlakeUidGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    SnowFlakeUidGenerator uidGenerator;

    @Autowired
    UserInfoEntityMapper userInfoEntityMapper;

    @Transactional
    public UserInfoEntity reg(UserRegInfo info) {
        String id = uidGenerator.nextIdByString();

        UserInfoEntity entity = new UserInfoEntity();
        entity.setId(id);
        entity.setCreateTime(S2u2mTimer.nowDate());
        entity.setNickName(info.getNickName());
        entity.setPassword(info.getPassword());
        userInfoEntityMapper.insert(entity);

        return entity;
    }
}
