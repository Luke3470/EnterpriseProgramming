<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Book Cards</title>
  <%@ include file="/WEB-INF/jsp/components/head.jspf" %>
</head>
  <%@ include file="/WEB-INF/jsp/components/scripts.jspf" %>
  <script src="${pageContext.request.contextPath}/js/index.js"></script>
<body class="bg-light" data-context-path="${pageContext.request.contextPath}">

<div class="container py-4">
  <%@ include file="/WEB-INF/jsp/components/header.jsp" %>
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

            <a href="${pageContext.request.contextPath}/books/${b.id()}"
               class="btn btn-primary btn-sm">
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
  <!-- Requires Inline Styles to load properly -->
<div style="position:fixed; top: 20px; right: 20px; width: 300px; z-index: 1055;">
  <c:if test="${not empty successMessage}">
    <div class="alert alert-success alert-dismissible fade show mb-0 text-center" role="alert">
        ${successMessage}
      <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
    </div>
  </c:if>
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
        <form id="deleteForm" method="post">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
            Cancel
          </button>

          <input type="hidden" name="id" id="deleteId">

          <button type="submit" class="btn btn-danger">
            Delete
          </button>
        </form>
      </div>

    </div>
  </div>
</div>
  <nav class="mt-4">
    <ul class="pagination justify-content-center">

      <li class="page-item ${currentPage == 1 ? 'disabled' : ''}">
        <a class="page-link"
           href="?page=${currentPage - 1}&books=${param.books}&dateFrom=${param.dateFrom}&dateTo=${param.dateTo}&genre=${param.genre}">
          Previous
        </a>
      </li>

      <li class="page-item ${currentPage == 1 ? 'active' : ''}">
        <a class="page-link"
           href="?page=1&books=${param.books}&dateFrom=${param.dateFrom}&dateTo=${param.dateTo}&genre=${param.genre}">
          1
        </a>
      </li>
      <c:if test="${currentPage > 3}">
        <li class="page-item disabled">
          <span class="page-link">...</span>
        </li>
      </c:if>

      <c:forEach begin="${currentPage - 1}" end="${currentPage + 1}" var="i">
        <c:if test="${i > 1 && i < totalPages}">
          <li class="page-item ${i == currentPage ? 'active' : ''}">
            <a class="page-link"
               href="?page=${i}&books=${param.books}&dateFrom=${param.dateFrom}&dateTo=${param.dateTo}&genre=${param.genre}">
                ${i}
            </a>
          </li>
        </c:if>
      </c:forEach>

      <c:if test="${currentPage < totalPages - 2}">
        <li class="page-item disabled">
          <span class="page-link">...</span>
        </li>
      </c:if>

      <c:if test="${totalPages > 1}">
        <li class="page-item ${currentPage == totalPages ? 'active' : ''}">
          <a class="page-link"
             href="?page=${totalPages}&books=${param.books}&dateFrom=${param.dateFrom}&dateTo=${param.dateTo}&genre=${param.genre}">
              ${totalPages}
          </a>
        </li>
      </c:if>

      <li class="page-item ${currentPage == totalPages ? 'disabled' : ''}">
        <a class="page-link"
           href="?page=${currentPage + 1}&books=${param.books}&dateFrom=${param.dateFrom}&dateTo=${param.dateTo}&genre=${param.genre}">
          Next
        </a>
      </li>

    </ul>
  </nav>
</body>
</html>