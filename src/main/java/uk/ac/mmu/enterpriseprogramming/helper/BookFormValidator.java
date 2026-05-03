package uk.ac.mmu.enterpriseprogramming.helper;

import java.util.HashMap;
import java.util.Map;
import uk.ac.mmu.enterpriseprogramming.model.data.BookVO;

public class BookFormValidator {

  public static Map<String, String> validate(BookVO book) {

    Map<String, String> errors = new HashMap<>();

    if (isBlank(book.title())) {
      errors.put("title", "Title is required");
    } else if (book.title().length() < 2) {
      errors.put("title", "Title too short");
    }

    if (isBlank(book.author())) {
      errors.put("author", "Author is required");
    }

    if (isBlank(book.date())) {
      errors.put("date", "Date is required");
    }

    if (book.coverUrl() != null && !book.coverUrl().isBlank()) {
      if (!isValidUrl(book.coverUrl())) {
        errors.put("coverUrl", "Invalid URL");
      }
    }

    return errors;
  }

  private static boolean isBlank(String s) {
    return s == null || s.isBlank();
  }

  private static boolean isValidUrl(String url) {
    try {
      new java.net.URL(url);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}