(function () {

  const UI = {
    "form-validate": function (form) {

      form.addEventListener("submit", function (e) {

        const dateFrom = form.querySelector("[name='dateFrom']");
        const dateTo = form.querySelector("[name='dateTo']");

        if (dateFrom && dateTo) {

          if (dateFrom.value && dateTo.value) {
            if (new Date(dateFrom.value) > new Date(dateTo.value)) {
              e.preventDefault();
              alert("Date From cannot be after Date To");
              return;
            }
          }
        }
      });

    },
    "genre-select": function (el) {
      if (typeof $ === 'undefined' || typeof $.fn.select2 === 'undefined') {
        console.error('Select2 not loaded');
        return;
      }

      $(el).select2({
        placeholder: "Select genres",
        width: '100%',
        theme: 'bootstrap-5',
        closeOnSelect: false
      });
    },

    "reset-form": function (el) {
      el.addEventListener("click", function () {
        const formId = el.getAttribute("data-form") || "searchForm";
        const form = document.getElementById(formId);

        if (!form) return;

        form.reset();

        if (typeof $ !== 'undefined' && $.fn.select2) {
          $(form).find('select').val(null).trigger('change');
        }
      });
    },

    "toggle-text": function (el) {

      const targetSelector = el.getAttribute("data-target");
      const moreText = el.getAttribute("data-text-more") || "Show more";
      const lessText = el.getAttribute("data-text-less") || "Show less";

      const textSpan = el.querySelector("span");
      const icon = el.querySelector("i");

      const target = document.querySelector(targetSelector);
      if (!target) return;

      target.addEventListener('shown.bs.collapse', function () {
        if (textSpan) textSpan.textContent = lessText;
        if (icon) {
          icon.classList.remove("fa-chevron-down");
          icon.classList.add("fa-chevron-up");
        }
      });

      target.addEventListener('hidden.bs.collapse', function () {
        if (textSpan) textSpan.textContent = moreText;
        if (icon) {
          icon.classList.remove("fa-chevron-up");
          icon.classList.add("fa-chevron-down");
        }
      });
    }

  };

  function initUI() {
    const elements = document.querySelectorAll("[data-ui]");

    elements.forEach(el => {
      const type = el.getAttribute("data-ui");

      if (UI[type]) {
        UI[type](el);
      } else {
        console.warn("No UI handler for:", type);
      }
    });
  }

  document.addEventListener("DOMContentLoaded", initUI);

})();