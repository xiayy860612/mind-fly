package com.s2u2m.mindfly.account;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The type Mind fly app.
 *
 * @author Amos Xia
 */
@SpringBootApplication
@MapperScan("com.s2u2m.mindfly.account.mapper")
public class MindFlyApp {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MindFlyApp.class, args);
    }

}
