<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Cards</title>

    <!-- Bootstrap CSS -->
    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
    >
</head>
<body class="bg-light">

<div class="container py-4">
    <h1 class="mb-4 text-center">Users</h1>

    <div class="row g-4">
        <!-- Loop through users -->
        <c:forEach var="u" items="${users}">
            <div class="col-md-4 col-lg-3">
                <div class="card shadow-sm h-100">
                    <div class="card-body">
                        <h5 class="card-title">${u.name}</h5>
                        <h6 class="card-subtitle mb-2 text-muted">${u.email}</h6>
                    </div>
                </div>
            </div>
        </c:forEach>

        <!-- Show placeholder if empty -->
        <c:if test="${empty users}">
            <p class="text-center text-muted">No users found.</p>
        </c:if>
    </div>
</div>

</body>
</html>
