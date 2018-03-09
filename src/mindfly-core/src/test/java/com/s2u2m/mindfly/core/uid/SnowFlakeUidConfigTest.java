package com.s2u2m.mindfly.core.uid;

import com.s2u2m.mindfly.core.BaseMindFlyTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.junit.Assert.*;

public class SnowFlakeUidConfigTest extends BaseMindFlyTest {

    @Autowired
    SnowFlakeUidGenerator generator;

    @Test
    public void generator_success() throws Exception {
        ZonedDateTime start = ZonedDateTime.of(2018, 1, 1,
                0, 0, 0, 0,
                ZoneId.of("UTC"));
        long startEpochMs = start.toInstant().toEpochMilli();

        Instant rst = Instant.ofEpochMilli(generator.getStartEpochMs());
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(rst, ZoneId.of("UTC"));

        assertEquals(startEpochMs, generator.getStartEpochMs());
    }

}