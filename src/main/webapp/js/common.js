document.addEventListener("DOMContentLoaded", () => {
  UI.init();
});

const UI = {
  init() {
    this.initSelect2();
    this.initToggleText();
    this.initResetButtons();
    this.initFormCleanEmptyParams();
    this.initFormValidation();
    this.setDateMaxToday();
  },

  initSelect2() {
    if (typeof $ === "undefined" || !$.fn.select2) return;

    document.querySelectorAll("[data-ui='genre-select']").forEach(el => {
      $(el).select2({
        placeholder: "Select genres",
        theme: "bootstrap-5",
        width: "100%"
      });
    });
  },

  initToggleText() {
    document.querySelectorAll("[data-ui='toggle-text']").forEach(el => {
      const targetSel = el.dataset.target;
      const moreText = el.dataset.textMore || "Show more";
      const lessText = el.dataset.textLess || "Show less";

      const target = document.querySelector(targetSel);
      if (!target) return;

      target.addEventListener("shown.bs.collapse", () => {
        el.querySelector("span").textContent = lessText;
        el.querySelector("i").classList.replace("fa-chevron-down", "fa-chevron-up");
      });

      target.addEventListener("hidden.bs.collapse", () => {
        el.querySelector("span").textContent = moreText;
        el.querySelector("i").classList.replace("fa-chevron-up", "fa-chevron-down");
      });
    });
  },

  initResetButtons() {
    document.querySelectorAll("[data-ui='reset-form']").forEach(btn => {
      btn.addEventListener("click", () => {
        const formId = btn.dataset.form || "searchForm";
        const form = document.getElementById(formId);
        if (!form) return;

        form.querySelectorAll("input").forEach(i => i.value = "");
        form.querySelectorAll("select").forEach(s => s.value = "");

        if (typeof $ !== "undefined" && $.fn.select2) {
          $(form).find("select").val(null).trigger("change");
        }
      });
    });
  },

  initFormCleanEmptyParams() {
    const form = document.getElementById("searchForm");
    if (!form) return;

    form.addEventListener("submit", () => {
      form.querySelectorAll("input, select").forEach(el => {
        if (!el.value || el.value === "") {
          el.removeAttribute("name");
        }
      });

      let page = form.querySelector("input[name='page']");
      if (page) page.value = "1";
    });
  },

  setDateMaxToday() {
    const dateInputs = document.querySelectorAll("input[type='date'][name='date']");
    if (!dateInputs.length) return;

    const today = new Date().toISOString().split("T")[0];

    dateInputs.forEach(input => {
      input.setAttribute("max", today);
    });
  },

  initFormValidation() {
    const forms = document.querySelectorAll(".needs-validation");

    forms.forEach(form => {

      form.querySelectorAll("input, textarea").forEach(input => {
        input.addEventListener("input", () => {
          this.validateField(input);
        });
      });

      form.addEventListener("submit", event => {
        let valid = true;

        form.querySelectorAll("input, textarea, select").forEach(el => {
          if (!this.validateField(el)) {
            valid = false;
          }
        });

        if (!valid) {
          event.preventDefault();
          event.stopPropagation();
        } else {
          this.sanitizeForm(form); // 🔥 XSS protection
        }

        form.classList.add("was-validated");
      });
    });
  },

  validateField(el) {
    const msgBox = el.parentElement.querySelector(".invalid-msg");

    let message = "";

    if (el.hasAttribute("required") && !el.value.trim()) {
      message = "This field is required.";
    }

    if (el.name === "title" && el.value && el.value.length < 2) {
      message = "Title must be at least 2 characters.";
    }

    if (el.name === "author" && el.value && el.value.length < 2) {
      message = "Author must be at least 2 characters.";
    }

    if (el.type === "url" && el.value && !this.isValidURL(el.value)) {
      message = "Please enter a valid URL.";
    }

    if (msgBox) {
      msgBox.textContent = message;
    }

    el.classList.toggle("is-invalid", !!message);
    el.classList.toggle("is-valid", !message && el.value.trim() !== "");

    return !message;
  },

  isValidURL(value) {
    try {
      new URL(value);
      return true;
    } catch {
      return false;
    }
  },


  sanitizeForm(form) {
    form.querySelectorAll("input, textarea").forEach(el => {
      if (!el.value) return;

      el.value = this.sanitize(el.value);
    });
  },

  sanitize(str) {
    return str
    .trim()
    .replace(/</g, "&lt;")
    .replace(/>/g, "&gt;")
    .replace(/"/g, "&quot;")
    .replace(/'/g, "&#039;");
  }
};