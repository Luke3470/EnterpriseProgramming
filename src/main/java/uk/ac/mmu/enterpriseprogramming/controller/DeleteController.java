package uk.ac.mmu.enterpriseprogramming.controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uk.ac.mmu.enterpriseprogramming.helper.Validator;
import uk.ac.mmu.enterpriseprogramming.model.BookDAO;

@WebServlet("/delete")
public class DeleteController extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
      IOException {
    try {
      int id = Validator.validateId(req.getParameter("id"));
      BookDAO bookDAO = (BookDAO) getServletContext().getAttribute("bookDAO");
      bookDAO.deleteBook(id);
      req.getSession().setAttribute("successMessage", "Book deleted successfully");
      System.out.println("DELETE SESSION ID: " + req.getSession().getId());
      System.out.println("SETTING MSG: " + req.getSession().getAttribute("successMessage"));

      resp.sendRedirect(req.getContextPath() + "/books");

    } catch (NumberFormatException e) {
        resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid id");
    }
  }
}
