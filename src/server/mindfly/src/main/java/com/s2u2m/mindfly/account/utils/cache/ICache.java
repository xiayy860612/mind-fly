package com.s2u2m.mindfly.account.utils.cache;

public interface ICache <KT, VT> {
    void set(KT key, VT value, long expireMs);

    VT get(KT key, Class<VT> vtClass);

    void del(KT key);
}
