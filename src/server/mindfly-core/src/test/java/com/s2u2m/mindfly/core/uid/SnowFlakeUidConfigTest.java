package com.s2u2m.mindfly.core.uid;

import com.s2u2m.mindfly.core.BaseCoreTest;
import com.s2u2m.mindfly.core.time.S2u2mTimer;
import io.swagger.models.auth.In;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.junit.Assert.*;

public class SnowFlakeUidConfigTest extends BaseCoreTest {

    @Test
    public void generator_success() throws Exception {
        Instant instant = Instant.now();
        ZonedDateTime start = ZonedDateTime.ofInstant(
                instant, ZoneId.of(S2u2mTimer.defaultZone));
        long startEpochMs = instant.toEpochMilli();
        SnowFlakeUidGenerator generator = new SnowFlakeUidGenerator(instant, 1);

        assertEquals(startEpochMs, generator.getStartEpochMs());
    }

}