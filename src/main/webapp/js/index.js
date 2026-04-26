document.addEventListener('DOMContentLoaded', function () {

  const deleteModal = document.getElementById('deleteModal');
  const contextPath = document.body.getAttribute("data-context-path");

  if (deleteModal) {
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
          contextPath + '/delete';

      document.getElementById('deleteId').value = id;
    });
  }

  setTimeout(function () {
    const alert = document.querySelector(".alert");

    if (alert) {
      const bsAlert = bootstrap.Alert.getOrCreateInstance(alert);
      bsAlert.close();
    }
  }, 3000);

});