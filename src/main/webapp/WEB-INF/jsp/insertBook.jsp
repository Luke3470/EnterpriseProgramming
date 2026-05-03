<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Insert New Book</title>
    <%@ include file="/WEB-INF/jsp/components/head.jspf" %>
</head>
<body class="bg-light">
<div class="container mt-5">
    <%@ include file="/WEB-INF/jsp/components/header.jsp" %>
    <div class="row justify-content-center">
        <div class="col-md-8">

            <div class="card shadow">
                <div class="card-header bg-primary text-white text-center">
                    <h3 class="mb-0">Add New Book</h3>
                </div>

                <div class="card-body">
                    <c:if test="${not empty errors}">
                        <div class="alert alert-danger">
                            Please fix the highlighted errors below.
                        </div>
                    </c:if>
                    <form action="${pageContext.request.contextPath}/add" method="post">
                        <input type="hidden" name="action" value="insert"/>

                        <div class="mb-3">
                            <label class="form-label">Title</label>
                            <input type="text" name="title" class="form-control"
                                   value="${book.title}" required>

                            <c:if test="${not empty errors.title}">
                                <div class="text-danger small">
                                        ${errors.title}
                                </div>
                            </c:if>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Author</label>
                            <input type="text" name="author" class="form-control"
                                   value="${book.author}" required>

                            <c:if test="${not empty errors.author}">
                                <div class="text-danger small">
                                        ${errors.author}
                                </div>
                            </c:if>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Publication Date</label>
                            <input type="date" name="date" class="form-control"
                                   value="${book.date}" required>

                            <c:if test="${not empty errors.date}">
                                <div class="text-danger small">
                                        ${errors.date}
                                </div>
                            </c:if>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Genres</label>
                            <input type="text" name="genres" class="form-control" placeholder="Fantasy, Adventure">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Characters</label>
                            <input type="text" name="characters" class="form-control" placeholder="Main characters">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Synopsis</label>
                            <textarea name="synopsis" class="form-control" rows="5"></textarea>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Cover URL</label>
                            <input type="text" name="coverUrl" class="form-control"
                                   value="${book.coverUrl}">

                            <c:if test="${not empty errors.coverUrl}">
                                <div class="text-danger small">
                                        ${errors.coverUrl}
                                </div>
                            </c:if>
                        </div>

                        <button type="submit" class="btn btn-success w-100">
                            Insert Book
                        </button>
                    </form>

                </div>
            </div>

        </div>
    </div>
</div>
<%@ include file="/WEB-INF/jsp/components/scripts.jspf" %>
</body>
</html>