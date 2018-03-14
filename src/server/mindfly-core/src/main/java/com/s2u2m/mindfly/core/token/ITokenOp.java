package com.s2u2m.mindfly.core.token;

public interface ITokenOp <DT extends AbTokenData> {

    String token(DT data);

    DT data(String token);
}
