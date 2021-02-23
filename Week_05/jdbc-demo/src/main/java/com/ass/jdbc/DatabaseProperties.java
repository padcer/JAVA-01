package com.ass.jdbc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DatabaseProperties {

    public static String url = "jdbc:postgresql://localhost:5432/test";

    public static String user = "postgres";

    public static String password = "123456";

    @Value("${jdbc.url}")
    public void setUrl(String url) {
        DatabaseProperties.url = url;
    }

    @Value("${jdbc.user}")
    public void setUser(String user) {
        DatabaseProperties.user = user;
    }

    @Value("${jdbc.password}")
    public void setPassword(String password) {
        DatabaseProperties.password = password;
    }
}
