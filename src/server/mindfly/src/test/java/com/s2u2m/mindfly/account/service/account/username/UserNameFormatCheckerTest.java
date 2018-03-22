package com.s2u2m.mindfly.account.service.account.username;

import com.s2u2m.mindfly.account.BaseAccountServiceTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UserNameFormatCheckerTest extends BaseAccountServiceTest {

    @Autowired
    UserNameFormatChecker checker;

    @Test
    public void check_1() throws Exception {
        String userName = "xiayy860612";
        assertTrue(checker.check(userName));
    }


    @Test
    public void check_2() throws Exception {
        String userName = "12xiayy860612";
        assertFalse(checker.check(userName));
    }


    @Test
    public void check_3() throws Exception {
        String userName = "xiayy@860612";
        assertFalse(checker.check(userName));
    }
}