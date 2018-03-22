package com.s2u2m.mindfly.account.controller;

import org.springframework.session.data.redis.config.annotation.web.http.RedisHttpSessionConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/common")
public class CommonController {

    @PostMapping(value = "/login")
    public String login(@RequestBody CommonPwdLoginReqDTO data,
                              HttpSession session) {
        Object attr = session.getAttribute("hello1");
        if (attr == null) {
            session.setAttribute("hello1", "world");
            System.out.println("hello not existed");
        } else {
            System.out.println("hello existed");
        }
        return "";
    }

}
