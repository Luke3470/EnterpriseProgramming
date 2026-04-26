<%@ page contentType="text/html; charset=UTF-8" isErrorPage="true" %>
<html>
<head>
  <title>405 - Method Not Allowed</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light d-flex align-items-center justify-content-center vh-100">

<div class="text-center">
  <h1 class="display-1 fw-bold text-warning">400</h1>
  <h3 class="mb-3">Method Not Allowed</h3>
  <p class="text-muted mb-4">The request was not an allowed method for this endpoint.</p>

  <a href="${pageContext.request.contextPath}/" class="btn btn-warning">
    Go Home
  </a>
</div>

</body>
</html>