document.addEventListener("DOMContentLoaded", () => {
  UI.init();
});

const UI = {
  init() {
    this.initSelect2();
    this.initToggleText();
    this.initResetButtons();
    this.initFormCleanEmptyParams();
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
        console.log("Loaded");
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
  }
};