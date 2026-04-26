<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Insert New Book</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body class="bg-light">

<div class="container mt-5">
    <%@ include file="/WEB-INF/jsp/header.jsp" %>
    <div class="row justify-content-center">
        <div class="col-md-8">

            <div class="card shadow">
                <div class="card-header bg-primary text-white text-center">
                    <h3 class="mb-0">Edit Book</h3>
                </div>

                <div class="card-body">

                    <form action="BookController" method="post">
                        <input type="hidden" name="action" value="insert"/>

                        <div class="mb-3">
                            <label class="form-label">Title</label>
                            <input type="text" name="title" class="form-control" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Author</label>
                            <input type="text" name="author" class="form-control" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Publication Date</label>
                            <input type="date" name="date" class="form-control" required>
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
                            <input type="text" name="coverUrl" class="form-control" placeholder="https://...">
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

<!-- Bootstrap JS (optional but useful) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>