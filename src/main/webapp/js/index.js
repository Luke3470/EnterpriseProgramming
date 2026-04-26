document.addEventListener('DOMContentLoaded', function () {

  const deleteModal = document.getElementById('deleteModal');

  deleteModal.addEventListener('show.bs.modal', function (event) {
    const button = event.relatedTarget;

    const id = button.getAttribute('data-id');
    const title = button.getAttribute('data-title');
    const author = button.getAttribute('data-author');
    const date = button.getAttribute('data-date');

    document.getElementById('modalTitle').textContent = title;
    document.getElementById('modalAuthor').textContent = author;
    document.getElementById('modalDate').textContent = date;

    document.getElementById('deleteForm').action =
        window.location.pathname.replace(/\/[^\/]*$/, '') +
        '/delete?id=' + id;
  });

});