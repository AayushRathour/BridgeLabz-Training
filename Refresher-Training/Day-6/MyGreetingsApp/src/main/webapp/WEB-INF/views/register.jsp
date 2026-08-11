<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register | My Greetings App</title>
    <style>
        body { font-family: 'Segoe UI', sans-serif; background: #0b0f14; color: #dbe4ee;
               display: flex; align-items: center; justify-content: center; height: 100vh; margin: 0; }
        .card { background: #121820; border: 1px solid #233040; border-radius: 12px; padding: 32px; width: 320px; }
        h2 { color: #7ee787; margin-top: 0; }
        label { font-size: 0.85rem; color: #8fa1b3; }
        input { width: 100%; padding: 10px; margin: 6px 0 16px; border-radius: 6px;
                border: 1px solid #233040; background: #0d1117; color: #dbe4ee; box-sizing: border-box; }
        button { width: 100%; padding: 10px; border-radius: 6px; border: none;
                 background: #7ee787; color: #0b0f14; font-weight: bold; cursor: pointer; }
        button:hover { opacity: 0.9; }
        .error { background: rgba(255,126,182,0.12); border: 1px solid #ff7eb6; color: #ff7eb6;
                 padding: 8px 12px; border-radius: 6px; font-size: 0.85rem; margin-bottom: 14px; }
        .link { text-align: center; margin-top: 14px; font-size: 0.85rem; }
        a { color: #5ecbf5; text-decoration: none; }
        a:hover { text-decoration: underline; }
    </style>
</head>
<body>
    <div class="card">
        <h2>Create Account</h2>

        <% if (request.getAttribute("error") != null) { %>
            <div class="error">${error}</div>
        <% } %>

        <form action="register" method="post">
            <label for="username">Username</label>
            <input type="text" id="username" name="username" required>

            <label for="password">Password</label>
            <input type="password" id="password" name="password" required>

            <button type="submit">Register</button>
        </form>

        <div class="link">
            Already have an account? <a href="login">Log in</a>
        </div>
    </div>
</body>
</html>
