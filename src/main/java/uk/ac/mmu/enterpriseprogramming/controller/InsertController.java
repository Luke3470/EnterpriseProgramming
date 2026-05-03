package uk.ac.mmu.enterpriseprogramming.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uk.ac.mmu.enterpriseprogramming.model.BookDAO;

@WebServlet("/add")
public class InsertController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
      ServletException, IOException {
    BookDAO bookDAO = (BookDAO) getServletContext().getAttribute("bookDAO");
    List<String> genres = bookDAO.getGenres();
    req.setAttribute("Genres", genres);
    req.getRequestDispatcher("WEB-INF/jsp/insertBook.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
      ServletException, IOException {
    BookDAO bookDAO = (BookDAO) getServletContext().getAttribute("bookDAO");

  }
}
