<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>My Greetings App</title>
    <style>
        body { font-family: 'Segoe UI', sans-serif; background: #0b0f14; color: #dbe4ee;
               display: flex; align-items: center; justify-content: center; height: 100vh; margin: 0; }
        .card { background: #121820; border: 1px solid #233040; border-radius: 12px; padding: 32px; width: 320px; }
        h2 { color: #5ecbf5; margin-top: 0; }
        input { width: 100%; padding: 10px; margin: 10px 0 18px; border-radius: 6px;
                border: 1px solid #233040; background: #0d1117; color: #dbe4ee; box-sizing: border-box; }
        button { width: 100%; padding: 10px; border-radius: 6px; border: none;
                 background: #5ecbf5; color: #0b0f14; font-weight: bold; cursor: pointer; }
        button:hover { opacity: 0.9; }
    </style>
</head>
<body>
    <div class="card">
        <h2>My Greetings App</h2>
        <form action="greeting" method="post">
            <label for="name">Your name:</label>
            <input type="text" id="name" name="name" placeholder="e.g. Aayush" required>
            <button type="submit">Greet Me</button>
        </form>
    </div>
</body>
</html>
