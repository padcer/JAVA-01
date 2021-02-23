package com.ass.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(School.class)
@ConditionalOnProperty(prefix = "school", name = "enable", havingValue = "true")
public class SchoolAutoConfiguration {
    @Autowired
    private School school;

    @Bean(name = "school")
    public SchoolService schoolService() {
        return new SchoolService(school.toString());
    }
}
