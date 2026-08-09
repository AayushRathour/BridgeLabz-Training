<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>My Greetings App</title>
    <style>
        body { font-family: 'Segoe UI', sans-serif; background: #0b0f14; color: #dbe4ee;
               display: flex; align-items: center; justify-content: center; height: 100vh; margin: 0; }
        .card { background: #121820; border: 1px solid #233040; border-radius: 12px; padding: 32px; width: 340px; }
        h2 { color: #7ee787; margin-top: 0; }
        a { color: #5ecbf5; text-decoration: none; }
        a:hover { text-decoration: underline; }
        .history { margin-top: 20px; padding-top: 14px; border-top: 1px solid #233040; }
        .history h4 { color: #8fa1b3; margin: 0 0 8px; font-size: 0.85rem; }
        .history ul { margin: 0; padding-left: 18px; font-size: 0.85rem; color: #8fa1b3; }
    </style>
</head>
<body>
    <div class="card">
        <h2>${message}</h2>
        <a href="greeting">&larr; Greet someone else</a>

        <c:if test="${not empty history}">
            <div class="history">
                <h4>Previously greeted</h4>
                <ul>
                    <c:forEach var="pastName" items="${history}">
                        <li>${pastName}</li>
                    </c:forEach>
                </ul>
            </div>
        </c:if>
    </div>
</body>
</html>
