package com.s2u2m.mindfly.core.serialization;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * The type Error response.
 *
 * @author Amos Xia
 */
@Getter
@Setter
public class ErrorResponse extends BaseResponse {
    private String errMsg = "";
}
