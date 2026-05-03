package uk.ac.mmu.enterpriseprogramming.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uk.ac.mmu.enterpriseprogramming.model.BookDAO;

@WebServlet("/edit")
public class UpdateController extends HttpServlet {


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
      ServletException, IOException {
    BookDAO bookDAO = (BookDAO) getServletContext().getAttribute("bookDAO");
    List<String> genres = bookDAO.getGenres();
    req.setAttribute("Genres", genres);
    req.getRequestDispatcher("WEB-INF/jsp/editBook.jsp").forward(req, resp);
  }

}
