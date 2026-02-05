package uk.ac.mmu.enterpriseprogramming.controller;

import uk.ac.mmu.enterpriseprogramming.model.UserModel;
import uk.ac.mmu.enterpriseprogramming.model.data.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;


@WebServlet("/users")
public class UserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<User> users = UserModel.getUsers();
        req.setAttribute("users", users);

        req.getRequestDispatcher("/WEB-INF/views/users.jsp").forward(req, resp);
    }
}


