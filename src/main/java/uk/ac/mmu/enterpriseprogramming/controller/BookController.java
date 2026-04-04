package uk.ac.mmu.enterpriseprogramming.controller;

import uk.ac.mmu.enterpriseprogramming.model.BookModel;
import uk.ac.mmu.enterpriseprogramming.model.data.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("")
public class BookController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<Book> books = BookModel.getBook();
        req.setAttribute("Books", books);

        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}


