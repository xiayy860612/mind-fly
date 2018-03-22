package com.s2u2m.mindfly.account.service.account.username;

import com.s2u2m.mindfly.account.BaseAccountServiceTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class PasswordFormatCheckerTest extends BaseAccountServiceTest {

    @Autowired
    PasswordFormatChecker checker;

    @Test
    public void check_1() throws Exception {
        String pwd = "xyy@123456";
        assertTrue(checker.check(pwd));
    }

    @Test
    public void check_2() throws Exception {
        String pwd = "xyy123456";
        assertFalse(checker.check(pwd));
    }
}