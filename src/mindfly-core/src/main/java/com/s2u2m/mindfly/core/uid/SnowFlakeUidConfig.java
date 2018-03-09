package com.s2u2m.mindfly.core.uid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;

@Configuration
public class SnowFlakeUidConfig {

    @Autowired
    SnowFlakeUidProperty property;

    @Bean
    public SnowFlakeUidGenerator generator() throws Exception {
        Instant start = Instant.ofEpochMilli(property.getStartTime());
        return new SnowFlakeUidGenerator(start, property.getWorkerId());
    }
}
