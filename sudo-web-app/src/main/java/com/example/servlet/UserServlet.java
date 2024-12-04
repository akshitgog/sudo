package com.example.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.UserDAO;

public class UserServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");

        boolean success = userDAO.addUser(username, email);
        if (success) {
            resp.sendRedirect("views/success.jsp");
        } else {
            req.setAttribute("errorMessage", "Failed to register user.");
            req.getRequestDispatcher("errors/error.jsp").forward(req, resp);
        }
    }
}
