<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${Book.title()}</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container mt-5">
    <%@ include file="/WEB-INF/jsp/header.jsp" %>
    <div class="card shadow-lg">
        <div class="row g-0">

            <div class="col-md-4">
                <img src="${Book.coverUrl()}"
                     class="img-fluid rounded-start h-100 object-fit-cover"
                     alt="Book Cover">
            </div>

            <div class="col-md-8">
                <div class="card-body">

                    <h2 class="card-title">${Book.title()}</h2>
                    <h5 class="text-muted">by ${Book.author()}</h5>

                    <hr>

                    <p><strong>Published:</strong> ${Book.date()}</p>
                    <p><strong>Genres:</strong> ${Book.genres()}</p>
                    <p><strong>Characters:</strong> ${Book.characters()}</p>

                    <hr>

                    <h5>Synopsis</h5>
                    <p class="card-text">${Book.synopsis()}</p>

                </div>
            </div>

        </div>
    </div>
</div>

</body>
</html>