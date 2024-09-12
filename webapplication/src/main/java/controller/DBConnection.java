package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; // 데이터베이스 URL
    private static final String USER = "system"; // 데이터베이스 사용자 이름
    private static final String PASSWORD = "1234"; // 데이터베이스 비밀번호

    // 데이터베이스 연결 메소드
    public static Connection getConnection() throws SQLException {
        // 데이터베이스 연결
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        return connection;
    }

    // 연결 종료 메소드
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
