package com.demo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
    urlPatterns = { "/LoginServlet" },
    initParams = {
        @WebInitParam(name = "user", value = "Aayush"),
        @WebInitParam(name = "password", value = "Aayush@123")
    }
)
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");
        String actualUser = getServletConfig().getInitParameter("user");
        String actualPwd = getServletConfig().getInitParameter("password");

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        if (!isValidName(user)) {
            out.println("Invalid name. Must start with capital letter, min 3 characters.");
        } else if (!isValidPassword(pwd)) {
            out.println("Invalid password. Min 8 chars, 1 uppercase, 1 digit, 1 special char.");
        } else if (user.equals(actualUser) && pwd.equals(actualPwd)) {
            request.setAttribute("user", user);
            request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);
        } else {
            out.println("Username or password is wrong.");
        }
    }

    // Username checking wich starts with capital letter, min 3 characters
    private boolean isValidName(String name) {
        return name != null && name.length() >= 3 && Character.isUpperCase(name.charAt(0));
    }

    // Password Checking min 8 chars, 1 uppercase, 1 digit, exactly 1 special char
    private boolean isValidPassword(String pwd) {
        if (pwd == null || pwd.length() < 8) return false;

        boolean hasUpper = false, hasDigit = false;
        int specialCount = 0;

        for (char ch : pwd.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else if (!Character.isLetterOrDigit(ch)) specialCount++;
        }

        return hasUpper && hasDigit && specialCount == 1;
    }
}