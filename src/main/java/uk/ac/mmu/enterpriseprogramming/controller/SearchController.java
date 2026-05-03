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
        List <String> genres = bookDAO.getGenres();
        int page = 1;
        int limit = 12;

        String pageParam = req.getParameter("page");
        if (pageParam != null) {
            page = Integer.parseInt(pageParam);
        }

        int offset = (page - 1) * limit;

        String q = req.getParameter("q");

        List<BookVO> books = bookDAO.getBooks(limit, offset);
        int count = bookDAO.countBooks();
        int totalPages = (int) Math.ceil((double) count / limit);

        req.setAttribute("Books", books);
        req.setAttribute("Genres", genres);
        req.setAttribute("currentPage", page);
        req.setAttribute("totalPages", totalPages);

        HttpSession session = req.getSession(false);

        if (session != null) {
            String msg = (String) session.getAttribute("successMessage");
            req.setAttribute("successMessage", msg);
            session.removeAttribute("successMessage");
        }
        req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, resp);
    }



}

