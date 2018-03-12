package com.s2u2m.mindfly.account.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CommonLoginRespDTO {
    private String token;
}
