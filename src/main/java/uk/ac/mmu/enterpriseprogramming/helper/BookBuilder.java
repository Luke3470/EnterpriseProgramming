package uk.ac.mmu.enterpriseprogramming.helper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.http.HttpServletRequest;
import uk.ac.mmu.enterpriseprogramming.model.data.BookVO;

public class BookBuilder {

  private static final DateTimeFormatter INPUT =
      DateTimeFormatter.ofPattern("yyyy-MM-dd");

  private static final DateTimeFormatter OUTPUT =
      DateTimeFormatter.ofPattern("dd/MM/yyyy");

  public static BookVO build(HttpServletRequest req) {

    String coverUrl = safe(req.getParameter("coverUrl"));

    if (coverUrl == null || coverUrl.isBlank()) {
      coverUrl = ImageUtils.PLACEHOLDER_URL;
    }

    return new BookVO(
        null,
        safe(req.getParameter("title")),
        safe(req.getParameter("author")),
        formatDate(req.getParameter("date")),
        safe(req.getParameter("genres")),
        safe(req.getParameter("characters")),
        safe(req.getParameter("synopsis")),
        coverUrl
    );

  }

  private static String safe(String value) {
    return value == null ? null : value.trim();
  }
  private static String formatDate(String date) {
    if (date == null || date.isBlank()) return null;

    LocalDate parsed = LocalDate.parse(date, INPUT);
    return parsed.format(OUTPUT);
  }

}