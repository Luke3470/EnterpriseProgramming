<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Book</title>
    <%@ include file="/WEB-INF/jsp/components/head.jspf" %>
</head>
<body class="bg-light">

<div class="container mt-5">
    <%@ include file="/WEB-INF/jsp/components/header.jsp" %>
    <div class="row justify-content-center">
        <div class="col-md-8">

            <div class="card shadow">
                <div class="card-header bg-primary text-white text-center">
                    <h3 class="mb-0">Edit Book</h3>
                </div>

                <div class="card-body">

                    <form action="${pageContext.request.contextPath}/edit" method="post">
                        <input type="hidden" name="action" value="edit"/>
                        <input type="hidden" name="id" value="${Book.id()}">
                        <div class="mb-3">
                            <label class="form-label">Title</label>
                            <input type="text" value="${Book.title()}" name="title" class="form-control" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Author</label>
                            <input type="text" value="${Book.author()}" name="author" class="form-control" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Publication Date</label>
                            <input type="date" value="${Book.date()}" name="date" class="form-control" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Genres</label>
                            <input type="text" value="${Book.genres()}" name="genres" class="form-control" placeholder="Fantasy, Adventure">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Characters</label>
                            <input type="text" value="${Book.characters()}"  name="characters" class="form-control" placeholder="Main characters">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Synopsis</label>
                            <textarea name="synopsis" value="${Book.synopsis()}" class="form-control" rows="5"></textarea>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Cover URL</label>
                            <input type="text" value="${Book.coverUrl()}" name="coverUrl" class="form-control" placeholder="https://...">
                        </div>

                        <button type="submit" class="btn btn-success w-100">
                            Edit Book
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