<%@ page contentType="text/html; charset=UTF-8" isErrorPage="true" %>
<html>
<head>
    <title>500 - Server Error</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light d-flex align-items-center justify-content-center vh-100">

<div class="text-center">
    <h1 class="display-1 fw-bold text-danger">500</h1>
    <h3 class="mb-3">Something went wrong</h3>
    <p class="text-muted mb-4">Our server encountered an error. Please try again later.</p>

    <a href="${pageContext.request.contextPath}/" class="btn btn-danger">
        Go Home
    </a>
</div>

</body>
</html>