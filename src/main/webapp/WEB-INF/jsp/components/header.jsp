<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="d-flex justify-content-between align-items-center mb-4">
  <h1 class="m-0">Books</h1>

  <div>
    <button class="btn btn-secondary me-2" onclick="history.back()">Back</button>
    <a href="${pageContext.request.contextPath}/add" class="btn btn-success">Add Book</a>
  </div>
</div>

<form class="mb-4"
      action="${pageContext.request.contextPath}/books"
      method="get"
      id="searchForm"
      data-ui="form-validate">

  <div class="input-group mb-3">
    <input type="text"
           class="form-control"
           name="books"
           placeholder="Search by title"
           value="${param.q}">
    <button class="btn btn-primary" type="submit">Search</button>
  </div>

  <a class="btn btn-link p-0 mb-3"
     data-bs-toggle="collapse"
     href="#extraFilters"
     data-ui="toggle-text"
     data-target="#extraFilters"
     data-text-more="Show more"
     data-text-less="Show less">

    <span>Show more</span>
    <i class="fa-solid fa-chevron-down ms-1"></i>
  </a>

  <div class="collapse" id="extraFilters"
       onshown.bs.collapse="document.getElementById('filterToggleText').textContent='Show less ▲'"
       onhidden.bs.collapse="document.getElementById('filterToggleText').textContent='Show more ▼'">

    <div class="card card-body border shadow-sm">
      <div class="row g-3">

        <div class="col-md-4">
          <label class="form-label">Date From</label>
          <input type="date"
                 class="form-control"
                 name="dateFrom"
                 value="${param.dateFrom}">
        </div>

        <div class="col-md-4">
          <label class="form-label">Date To</label>
          <input type="date"
                 class="form-control"
                 name="dateTo"
                 value="${param.dateTo}">
        </div>

        <div class="col-md-4">

          <label class="form-label">Genres</label>

          <select class="form-select"
                  name="genre"
                  multiple
                  size="6"
                  data-ui="genre-select">

            <c:forEach var="g" items="${Genres}">
              <option value="${g}"
                      <c:forEach var="pg" items="${paramValues.genre}">
                        <c:if test="${pg == g}">
                          selected="selected"
                        </c:if>
                      </c:forEach>>
                  ${g}
              </option>
            </c:forEach>

          </select>
        </div>

        <div class="col-md-4 d-flex align-items-end gap-2">
          <button class="btn btn-outline-primary w-50" type="submit">Apply</button>
          <button class="btn btn-outline-danger w-50"
                  type="button"
                  data-ui="reset-form"
                  data-form="searchForm">
            Reset
          </button>
        </div>

      </div>
    </div>
  </div>

</form>

