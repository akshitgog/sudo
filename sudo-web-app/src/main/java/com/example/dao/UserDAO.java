package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {
    private final String url = "jdbc:mysql://localhost:3306/sudoku";
    private final String user = "root";
    private final String password = "Jain@7042123137";

    public boolean addUser(String username, String email) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO users (username, email) VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, username);
                stmt.setString(2, email);
                int rowsAffected = stmt.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
