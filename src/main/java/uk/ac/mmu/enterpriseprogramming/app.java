package uk.ac.mmu.enterpriseprogramming;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import uk.ac.mmu.enterpriseprogramming.DB.DB;
import uk.ac.mmu.enterpriseprogramming.DB.MySQLDB;
import uk.ac.mmu.enterpriseprogramming.model.BookDAO;
import uk.ac.mmu.enterpriseprogramming.model.BookDAOImpl;

@WebListener
public class app implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {

    DB db = new MySQLDB();
    BookDAO bookDAO = new BookDAOImpl(db);

    ServletContext ctx = sce.getServletContext();
    ctx.setAttribute("bookDAO", bookDAO);
  }
}