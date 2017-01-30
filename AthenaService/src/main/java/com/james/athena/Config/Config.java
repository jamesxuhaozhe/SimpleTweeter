package com.james.athena.Config;

import com.james.athena.handler.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by haozhexu on 1/29/17.
 */
@Configuration
public class Config {

    @Bean
    public UserHandler userHandler() {
        return new UserHandler();
    }
}
