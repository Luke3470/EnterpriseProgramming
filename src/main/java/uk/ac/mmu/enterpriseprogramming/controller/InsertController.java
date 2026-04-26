package uk.ac.mmu.enterpriseprogramming.controller;

import java.io.IOException;
import java.lang.ModuleLayer.Controller;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class InsertController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
      ServletException, IOException {
    req.getRequestDispatcher("WEB-INF/jsp/insertBook.jsp").forward(req, resp);
  }
}
