package com.ass.jdbc;


import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@SpringBootApplication
public class JdbcApplication {
    public static void main(String[] args) {
        Connection conn = Database.getConn();
        String sql = null;
        PreparedStatement preparedStatement;
        Integer id = 1112;

        try {
            // 关闭自动提交:
            conn.setAutoCommit(false);

            // 1. insert
            sql = "INSERT into base_user (id, name) values(?, ?)";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, "qq");
            preparedStatement.execute();

            // 2. update
            sql = "UPDATE base_user SET name = ? WHERE id = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, "test");
            preparedStatement.setInt(2, id);
            preparedStatement.execute();

            // 3. query
            sql = "SELECT * FROM base_user WHERE id = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getLong("id"));
                System.out.println(resultSet.getString("name"));
            }

            // 4. delete
            sql = "DELETE FROM base_user WHERE id = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();

            // 5. batch update 批处理
            preparedStatement = conn.prepareStatement("UPDATE base_user SET name = ? WHERE id = ?");
            preparedStatement.setString(1, "test2");
            preparedStatement.setInt(2, id);
            preparedStatement.addBatch();
            preparedStatement.setString(1, "test2");
            preparedStatement.setInt(2, id);
            preparedStatement.addBatch();
            preparedStatement.executeBatch();
            preparedStatement.clearBatch();

            // 提交事务:
            conn.commit();

            resultSet.close();
            preparedStatement.close();
            conn.close();
        } catch (SQLException e) {
            try {
                // 回滚事务:
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}
