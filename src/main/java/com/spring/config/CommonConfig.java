package com.spring.config;

import com.spring.common.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig {
    @Bean
    public Student student() {
        return new Student();
    }
}
