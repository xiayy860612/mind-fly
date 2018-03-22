package com.s2u2m.mindfly.account.utils.notify;

public interface INotify<
        DT extends AbNotifyDest,
        PT extends AbNotifyParam> {
    void notify(DT dest, PT param);
}
