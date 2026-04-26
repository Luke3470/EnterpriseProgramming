<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>404 - Not Found</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light d-flex align-items-center justify-content-center vh-100">

<div class="text-center">
    <h1 class="display-1 fw-bold text-primary">404</h1>
    <h3 class="mb-3">Page Not Found</h3>
    <p class="text-muted mb-4">The page you are looking for doesn’t exist or has been moved.</p>

    <a href="${pageContext.request.contextPath}/" class="btn btn-primary">
        Go Home
    </a>
</div>

</body>
</html>