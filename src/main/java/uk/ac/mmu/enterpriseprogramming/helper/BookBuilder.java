package uk.ac.mmu.enterpriseprogramming.helper;

import javax.servlet.http.HttpServletRequest;
import uk.ac.mmu.enterpriseprogramming.model.data.BookVO;

public class BookBuilder {

  public static BookVO build(HttpServletRequest req) {

    String coverUrl = safe(req.getParameter("coverUrl"));

    if (coverUrl == null || coverUrl.isBlank()) {
      coverUrl = ImageUtils.PLACEHOLDER_URL;
    }

    return new BookVO(
        null,
        safe(req.getParameter("title")),
        safe(req.getParameter("author")),
        safe(req.getParameter("date")),
        safe(req.getParameter("genres")),
        safe(req.getParameter("characters")),
        safe(req.getParameter("synopsis")),
        coverUrl
    );

  }

  public static BookVO edit(HttpServletRequest req) {

    String coverUrl = safe(req.getParameter("coverUrl"));

    if (coverUrl == null || coverUrl.isBlank()) {
      coverUrl = ImageUtils.PLACEHOLDER_URL;
    }

    Integer id = Integer.parseInt(req.getParameter("id"));

    return new BookVO(
        id,
        safe(req.getParameter("title")),
        safe(req.getParameter("author")),
        safe(req.getParameter("date")),
        safe(req.getParameter("genres")),
        safe(req.getParameter("characters")),
        safe(req.getParameter("synopsis")),
        coverUrl
    );

  }

  private static String safe(String value) {
    return value == null ? null : value.trim();
  }


}