package com.s2u2m.mindfly.account.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/common")
public class CommonController {

    @PostMapping(value = "/login")
    public LoginRespDTO login(@RequestBody CommonPwdLoginReqDTO data) {
        return null;
    }

}
