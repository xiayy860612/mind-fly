package com.s2u2m.mindfly.core.serialization;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * The type Response.
 *
 * @param <T>  the type parameter
 */
@Getter
@Setter
public class Response<T extends ResponseData> extends BaseResponse {
    private T data;
}
