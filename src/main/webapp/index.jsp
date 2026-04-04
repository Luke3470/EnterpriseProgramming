<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Book Cards</title>
  <link
          rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
  >
</head>
<body class="bg-light">

<div class="container py-4">
  <h1 class="mb-4 text-center">Books</h1>

  <div class="row g-4">
    <c:forEach var="b" items="${Books}">
      <div class="col-md-4 col-lg-3">
        <div class="card shadow-sm h-100">
          <div class="card-body">
            <h5 class="card-title">${b.title}</h5>
            <h6 class="card-subtitle mb-2 text-muted">${b.author}</h6>
          </div>
        </div>
      </div>
    </c:forEach>


    <c:if test="${empty Books}">
      <p class="text-center text-muted">No Books found.</p>
    </c:if>
  </div>
</div>

</body>
</html>
