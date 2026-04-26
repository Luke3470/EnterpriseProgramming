package uk.ac.mmu.enterpriseprogramming.controller;


import java.util.List;
import uk.ac.mmu.enterpriseprogramming.model.BookDAO;
import uk.ac.mmu.enterpriseprogramming.model.data.BookVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;


@WebServlet("/books")
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
        HttpSession session = req.getSession(false);

        System.out.println("BOOKS SESSION ID: " + (session != null ? session.getId() : "NO SESSION"));

        if (session != null) {
            String msg = (String) session.getAttribute("successMessage");

            System.out.println("READ MSG: " + msg);

            req.setAttribute("successMessage", msg);

            session.removeAttribute("successMessage");
        }
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }



}

