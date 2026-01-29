package uk.ac.mmu.enterpriseprogramming.controller;

import uk.ac.mmu.enterpriseprogramming.model.UserModel;
import uk.ac.mmu.enterpriseprogramming.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;


@WebServlet("/users")
public class UserController extends HttpServlet {

    private UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<UserModel> users = service.getAllUsers();

        req.setAttribute("users", users);


        req.getRequestDispatcher("/WEB-INF/views/users.jsp").forward(req, resp);
    }
}


