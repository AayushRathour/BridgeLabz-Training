<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>My Greetings App</title>
    <style>
        body { font-family: 'Segoe UI', sans-serif; background: #0b0f14; color: #dbe4ee;
               display: flex; align-items: center; justify-content: center; height: 100vh; margin: 0; }
        .card { background: #121820; border: 1px solid #233040; border-radius: 12px; padding: 32px; width: 340px; text-align: center; }
        h2 { color: #5ecbf5; margin-top: 0; }
        p { color: #8fa1b3; font-size: 0.9rem; }
        a.btn { display: inline-block; margin-top: 10px; background: #5ecbf5; color: #0b0f14; padding: 10px 20px;
                border-radius: 6px; text-decoration: none; font-weight: bold; }
        a.btn:hover { opacity: 0.9; }
        a.logout { color: #ff7eb6; text-decoration: none; font-size: 0.8rem; }
        a.logout:hover { text-decoration: underline; }
    </style>
</head>
<body>
    <div class="card">
        <h2>My Greetings App</h2>

        <% if (session.getAttribute("loggedInUser") != null) { %>
            <%
                com.aayush.greetings.model.User loggedInUser =
                    (com.aayush.greetings.model.User) session.getAttribute("loggedInUser");
            %>
            <p>Logged in as <strong><%= loggedInUser.getUsername() %></strong></p>
            <a class="btn" href="greetings">My Greetings</a>
            <br><br>
            <a class="logout" href="logout">Logout</a>
        <% } else { %>
            <p>You are not logged in.</p>
            <a class="btn" href="login">Log In</a>
            <br><br>
            <a href="register" style="color:#5ecbf5;text-decoration:none;font-size:0.85rem;">Create an account</a>
        <% } %>
    </div>
</body>
</html>
