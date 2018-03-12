package com.s2u2m.mindfly.account.controller;

import com.s2u2m.mindfly.account.dto.CommonAccountRegReqDTO;
import com.s2u2m.mindfly.account.dto.CommonLoginReqDTO;
import com.s2u2m.mindfly.account.dto.CommonLoginRespDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/common")
public class CommonAccountController {

    @PostMapping(value = "register")
    public CommonLoginRespDTO reg(@RequestBody CommonAccountRegReqDTO data) {
        return CommonLoginRespDTO.builder().token("").build();
    }

    @PostMapping(value = "/login")
    public CommonLoginRespDTO login(@RequestBody CommonLoginReqDTO data) {

        return CommonLoginRespDTO.builder().token("").build();
    }

}
