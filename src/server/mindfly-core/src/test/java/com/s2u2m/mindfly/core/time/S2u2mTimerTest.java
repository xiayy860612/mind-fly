package com.s2u2m.mindfly.core.time;

import com.s2u2m.mindfly.core.BaseCoreTest;
import org.junit.Assert;
import org.junit.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import static org.junit.Assert.*;

public class S2u2mTimerTest extends BaseCoreTest {
    @Test
    public void nowDate() throws Exception {
        ZonedDateTime expected = ZonedDateTime.now(
                ZoneId.of(S2u2mTimer.defaultZone));

        Date now = S2u2mTimer.nowDate();
        ZonedDateTime rst = ZonedDateTime.ofInstant(
                now.toInstant(), ZoneId.of(S2u2mTimer.defaultZone));

        Assert.assertEquals(expected.getHour(), rst.getHour());
    }

}