package uk.ac.mmu.enterpriseprogramming.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uk.ac.mmu.enterpriseprogramming.helper.Validator;
import uk.ac.mmu.enterpriseprogramming.model.BookDAO;
import uk.ac.mmu.enterpriseprogramming.model.data.BookVO;

@WebServlet("/books/*")
public class ViewSingleBookController extends HttpServlet {


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String path = req.getPathInfo();

    if (path == null || path.equals("/")) {
      resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid id");
      return;
    }

    String cleansedPath = path.substring(1);

    try {
      int id = Validator.validateId(cleansedPath);

      BookDAO bookDAO = (BookDAO) getServletContext().getAttribute("bookDAO");

      List<String> genres = bookDAO.getGenres();
      req.setAttribute("Genres", genres);

      BookVO book = bookDAO.getBook(id);
      req.setAttribute("Book", book);

      req.getRequestDispatcher("/WEB-INF/jsp/singleBook.jsp").forward(req, resp);
    } catch (NumberFormatException e) {
      resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid id");
    }
  }

}
