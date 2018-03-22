package com.s2u2m.mindfly.account.utils.random;

import com.s2u2m.mindfly.account.BaseAccountServiceTest;
import org.junit.Test;

import static org.junit.Assert.*;

public class RandomUtilTest extends BaseAccountServiceTest {
    @Test
    public void nextString() throws Exception {
        int len = 6;
        String value = RandomUtil.nextString(len);
        assertEquals(len, value.length());
    }

}