<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>My Greetings</title>
    <style>
        body { font-family: 'Segoe UI', sans-serif; background: #0b0f14; color: #dbe4ee; margin: 0; padding: 30px; }
        .wrap { max-width: 600px; margin: 0 auto; }
        .topbar { display: flex; justify-content: space-between; align-items: center; margin-bottom: 20px; }
        h2 { color: #5ecbf5; margin: 0; }
        .welcome { color: #8fa1b3; font-size: 0.85rem; }
        a.btn { background: #5ecbf5; color: #0b0f14; padding: 8px 16px; border-radius: 6px;
                text-decoration: none; font-weight: bold; font-size: 0.85rem; }
        a.home { color: #8fa1b3; text-decoration: none; font-size: 0.8rem; }
        a.logout { color: #ff7eb6; text-decoration: none; font-size: 0.8rem; margin-left: 12px; }
        table { width: 100%; border-collapse: collapse; background: #121820; border: 1px solid #233040; border-radius: 10px; overflow: hidden; }
        th, td { padding: 12px 14px; text-align: left; border-bottom: 1px solid #233040; font-size: 0.9rem; }
        th { background: #161d27; color: #8fa1b3; font-size: 0.78rem; text-transform: uppercase; }
        tr:last-child td { border-bottom: none; }
        a.edit { color: #ffcb6b; text-decoration: none; margin-right: 12px; font-size: 0.85rem; }
        a.delete { color: #ff7eb6; text-decoration: none; font-size: 0.85rem; }
        a.edit:hover, a.delete:hover { text-decoration: underline; }
        .empty { color: #8fa1b3; text-align: center; padding: 30px; }
    </style>
</head>
<body>
<div class="wrap">
    <div class="topbar">
        <div>
            <h2>My Greetings</h2>
            <span class="welcome">
                <a class="home" href="${pageContext.request.contextPath}/">&larr; Home</a>
                &nbsp;|&nbsp; ${user.username}
                <a class="logout" href="${pageContext.request.contextPath}/logout">Logout</a>
            </span>
        </div>
        <a class="btn" href="${pageContext.request.contextPath}/greetings/new">+ Add Greeting</a>
    </div>

    <c:choose>
        <c:when test="${empty greetings}">
            <div class="empty">No greetings yet. Click "Add Greeting" to create your first one.</div>
        </c:when>
        <c:otherwise>
            <table>
                <tr><th>Name</th><th></th></tr>
                <c:forEach var="g" items="${greetings}">
                    <tr>
                        <td>Hello, ${g.name}!</td>
                        <td>
                            <a class="edit" href="${pageContext.request.contextPath}/greetings/edit/${g.id}">Edit</a>
                            <a class="delete" href="${pageContext.request.contextPath}/greetings/delete/${g.id}"
                               onclick="return confirm('Delete this greeting?');">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
