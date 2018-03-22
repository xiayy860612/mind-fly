package com.s2u2m.mindfly.account.utils.cache.redis;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
class RedisData {
    private int id;
    private String name;
}
