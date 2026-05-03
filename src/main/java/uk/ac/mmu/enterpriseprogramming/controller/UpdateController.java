package uk.ac.mmu.enterpriseprogramming.controller;

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
import uk.ac.mmu.enterpriseprogramming.helper.Validator;
import uk.ac.mmu.enterpriseprogramming.model.BookDAO;
import uk.ac.mmu.enterpriseprogramming.model.data.BookVO;

@WebServlet("/edit")
public class UpdateController extends HttpServlet {


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
      ServletException, IOException {
    BookDAO bookDAO = (BookDAO) getServletContext().getAttribute("bookDAO");
    List<String> genres = bookDAO.getGenres();

    try {
      int id = Validator.validateId(req.getParameter("id"));
      req.setAttribute("Genres", genres);
      BookVO book = bookDAO.getBook(id);

      if (book == null) {
        resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Book not found");
        return;
      }

      req.setAttribute("Book", book);
      req.getRequestDispatcher("/WEB-INF/jsp/editBook.jsp").forward(req, resp);
    } catch (NumberFormatException e) {

      resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid id");
    }

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
        req.getRequestDispatcher("/WEB-INF/jsp/editBook.jsp").forward(req, resp);
        return;
      }

      bookDAO.updateBook(book);
      req.getSession().setAttribute("successMessage", "Book Edited successfully");

      resp.sendRedirect(req.getContextPath() + "/books");

    } catch (Exception e) {
      resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
    }
  }

}
