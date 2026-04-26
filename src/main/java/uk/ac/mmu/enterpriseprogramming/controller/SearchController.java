package uk.ac.mmu.enterpriseprogramming.controller;


import java.util.List;
import uk.ac.mmu.enterpriseprogramming.DB.DB;
import uk.ac.mmu.enterpriseprogramming.DB.MySQLDB;
import uk.ac.mmu.enterpriseprogramming.model.BookDAO;
import uk.ac.mmu.enterpriseprogramming.model.BookDAOImpl;
import uk.ac.mmu.enterpriseprogramming.model.data.BookVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;


@WebServlet("")
public class SearchController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        BookDAO bookDAO = (BookDAO) getServletContext().getAttribute("bookDAO");

        int limit = 12;
        int offset = 0;

        String q = req.getParameter("q");

        List<BookVO> books = bookDAO.getBooks(limit, offset);

        req.setAttribute("Books", books);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }



}

