package com.s2u2m.mindfly.account.config.uid;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:snow-flake-uid.properties")
@ConfigurationProperties(prefix = "uid")
@Getter
@Setter
public class SnowFlakeUidProperty {
	private long startTime;
	private int workerId;
}
