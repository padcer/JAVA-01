package com.ass.starter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "school")
public class School {
    private Boolean enable;
    private String name;
    private List<Student> students;
}
