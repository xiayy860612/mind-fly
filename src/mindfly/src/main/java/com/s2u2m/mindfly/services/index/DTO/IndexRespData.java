package com.s2u2m.mindfly.services.index.DTO;

import com.s2u2m.mindfly.core.serialization.ResponseData;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class IndexRespData extends ResponseData {
    private String msg;
}
