package com.example.dao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserDAOTest {
    @Test
    public void testAddUser() {
        UserDAO userDAO = new UserDAO();
        boolean result = userDAO.addUser("test_user", "test_email@example.com");
        assertTrue(result);
    }
}
