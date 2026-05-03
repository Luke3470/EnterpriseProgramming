package uk.ac.mmu.enterpriseprogramming.controller;

import java.awt.print.Book;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uk.ac.mmu.enterpriseprogramming.helper.BookBuilder;
import uk.ac.mmu.enterpriseprogramming.helper.BookFormValidator;
import uk.ac.mmu.enterpriseprogramming.helper.ImageUtils;
import uk.ac.mmu.enterpriseprogramming.helper.Validator;
import uk.ac.mmu.enterpriseprogramming.model.BookDAO;
import uk.ac.mmu.enterpriseprogramming.model.data.BookVO;

@WebServlet("/add")
public class InsertController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
      ServletException, IOException {
    BookDAO bookDAO = (BookDAO) getServletContext().getAttribute("bookDAO");
    List<String> genres = bookDAO.getGenres();
    req.setAttribute("Genres", genres);
    req.setAttribute("Url", ImageUtils.PLACEHOLDER_URL);
    req.getRequestDispatcher("WEB-INF/jsp/insertBook.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
      ServletException, IOException {
    BookDAO bookDAO = (BookDAO) getServletContext().getAttribute("bookDAO");
    try {

      BookVO book = BookBuilder.build(req);

      Map<String, String> errors = BookFormValidator.validate(book);

      if (!errors.isEmpty()) {
        req.setAttribute("errors", errors);
        req.setAttribute("book", BookBuilder.build(req));
        req.getRequestDispatcher("/WEB-INF/jsp/insertBook.jsp").forward(req, resp);
        return;
      }

      bookDAO.addBook(book);
      req.getSession().setAttribute("successMessage", "Book added successfully");

      resp.sendRedirect(req.getContextPath() + "/books");

    } catch (Exception e) {
      resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
    }
  }

}
