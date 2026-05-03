package uk.ac.mmu.enterpriseprogramming.helper;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import java.util.List;

import uk.ac.mmu.enterpriseprogramming.DB.DB;
import uk.ac.mmu.enterpriseprogramming.DB.MySQLDB;
import uk.ac.mmu.enterpriseprogramming.model.BookDAO;
import uk.ac.mmu.enterpriseprogramming.model.BookDAOImpl;
import uk.ac.mmu.enterpriseprogramming.model.data.BookVO;

public class cleanDb {

  private static final Gson gson = new Gson();

  public static void main(String[] args) {
    /*
    * Clean db Script
    *
    *
    *
    * */
    System.out.println("Starting DB Clean Script");

    DB db = new MySQLDB();
    BookDAO booksDAO = new BookDAOImpl(db);
    cleanDB(booksDAO);
    System.out.println("Finished DB Clean Script");
  }

  public static void cleanDB(BookDAO booksDAO) {
    List<BookVO> books = booksDAO.getAllBooks();
    for(BookVO book : books){
      String formattedDate = normalizeDate(book.date());

      if (formattedDate == null) {
        booksDAO.deleteBook(book.id());
        continue;
      }
      String url = book.coverUrl();

      if (url == null || url.isBlank()) {
        url = fetchCoverUrl(book);
      }

      BookVO updatedBook = new BookVO(
          book.id(),
          book.title(),
          book.author(),
          formattedDate,
          book.genres(),
          book.characters(),
          book.synopsis(),
          url
      );

      booksDAO.updateBook(updatedBook);
    }
  }


  public static String fetchCoverUrl(BookVO b) {
    int maxRetries = 3;
    int attempt = 0;

    while (attempt < maxRetries) {
      try {
        String apiUrl = "https://bookcover.longitood.com/bookcover?book_title="
            + URLEncoder.encode(b.title(), "UTF-8")
            + "&author_name="
            + URLEncoder.encode(b.author(), "UTF-8");

        HttpURLConnection con = (HttpURLConnection) new URL(apiUrl).openConnection();
        con.setRequestMethod("GET");
        con.setConnectTimeout(4000);
        con.setReadTimeout(4000);

        int status = con.getResponseCode();

        if (status == 429) {
          System.out.println("Rate limited. Waiting 30 seconds before retry...");
          Thread.sleep(30000);
          attempt++;
          continue;
        }
        if (status == 404) {
          System.out.println("No Cover found");
          attempt = maxRetries;
          continue;
        }
        if (status == 200) {
          System.out.println("Cover found for "+b.title());
        }

        BufferedReader reader = new BufferedReader(
            new InputStreamReader(con.getInputStream())
        );

        StringBuilder jsonText = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
          jsonText.append(line);
        }

        reader.close();

        JsonObject json = gson.fromJson(jsonText.toString(), JsonObject.class);

        if (json != null && json.has("url")) {
          return json.get("url").getAsString();
        }

        return ImageUtils.PLACEHOLDER_URL;

      } catch (Exception e) {
        attempt++;
        try {
          Thread.sleep(30000);
        } catch (InterruptedException ignored) {}
      }
    }

    return ImageUtils.PLACEHOLDER_URL;
  }

  public static String normalizeDate(String date) {

    if (date == null || date.isBlank()) return null;

    DateTimeFormatter dbFormat =
        DateTimeFormatter.ofPattern("dd/MM/yyyy");

    DateTimeFormatter inputFormat =
        DateTimeFormatter.ofPattern("yyyy-MM-dd");

    DateTimeFormatter[] formats = { dbFormat, inputFormat };

    for (DateTimeFormatter f : formats) {
      try {
        LocalDate parsed = LocalDate.parse(date, f);
        return parsed.format(dbFormat);
      } catch (DateTimeParseException ignored) {}
    }

    return null;
  }

}
