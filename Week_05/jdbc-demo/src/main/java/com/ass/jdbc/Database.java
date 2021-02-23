package com.ass.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static class DatabaseConn {
        private static Connection conn;

        static {
            try {
                conn = DriverManager.getConnection(
                            DatabaseProperties.url,
                            DatabaseProperties.user,
                            DatabaseProperties.password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static Connection getConn() {
        return DatabaseConn.conn;
    }
}
