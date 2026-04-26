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
  <link rel="stylesheet" href="css/styles.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
  <script src="js/index.js"></script>
</head>
<body class="bg-light">

<div class="container py-4">
  <h1 class="mb-4 text-center">Books</h1>

  <form class="mb-4" action="/" method="get">
    <div class="input-group">
      <input type="text"
             class="form-control"
             name="q"
             placeholder="Search by title"
             value="${param.q}">
      <button class="btn btn-primary" type="submit">Search</button>
    </div>
  </form>

  <div class="row g-4">
    <c:forEach var="b" items="${Books}">
      <div class="col-md-4 col-lg-3">
        <div class="card shadow-sm h-200">
          <div class="card-body">
            <img
                    src="${b.coverUrl()}"
                    class="card-img-top"
                    alt="${b.title()}"
            >
            <h5 class="card-title">${b.title()}</h5>
            <h6 class="card-author text-muted">${b.author()}</h6>
          </div>
          <div class="mt-auto d-flex gap-2 justify-content-center pb-4">

            <a href="view?id=${b.id()}" class="btn btn-primary btn-sm">
              <i class="fa-solid fa-book-open"></i>
            </a>

            <a href="edit?id=${b.id()}" class="btn btn-warning btn-sm">
              <i class="fa-solid fa-pen-to-square"></i>
            </a>

            <a href="#"
               class="btn btn-danger btn-sm"
               data-bs-toggle="modal"
               data-bs-target="#deleteModal"
               data-id="${b.id()}"
               data-title="${b.title()}"
               data-author="${b.author()}"
               data-date="${b.date()}">
              <i class="fa-solid fa-trash"></i>
            </a>

          </div>
        </div>
      </div>
    </c:forEach>

    <c:if test="${empty Books}">
      <p class="text-center text-muted">No Books found.</p>
    </c:if>

  </div>
</div>
<div class="modal fade" id="deleteModal" tabindex="-1" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">

      <div class="modal-header">
        <h5 class="modal-title">Confirm Delete</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <div class="modal-body">
        <p>Are you sure you want to delete this book?</p>

        <p><strong>Title:</strong> <span id="modalTitle"></span></p>
        <p><strong>Author:</strong> <span id="modalAuthor"></span></p>
        <p><strong>Date:</strong> <span id="modalDate"></span></p>
      </div>

      <div class="modal-footer">
        <form id="deleteForm" method="get">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
            Cancel
          </button>
          <button type="submit" class="btn btn-danger">
            Delete
          </button>
        </form>
      </div>

    </div>
  </div>
</div>
</body>
</html>