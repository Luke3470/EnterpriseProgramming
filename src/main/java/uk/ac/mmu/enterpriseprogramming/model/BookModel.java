package uk.ac.mmu.enterpriseprogramming.model;

import uk.ac.mmu.enterpriseprogramming.DB.DB;
import uk.ac.mmu.enterpriseprogramming.DB.MySQLDB;
import uk.ac.mmu.enterpriseprogramming.model.data.Book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class BookModel {

    public static List<Book> getBook(){
        List<Book> userList = new ArrayList<Book>();

        String query = "SELECT * FROM books";
        DB db = new MySQLDB();
        try(Connection conn = db.createCon()){
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                Book user = new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("date"),
                        rs.getString("genres"),
                        rs.getString("characters"),
                        rs.getString("synopsis")
                );
                userList.add(user);
            }
            return userList;
        }catch (Exception e){
            System.out.println(Arrays.toString(e.getStackTrace()));
            return null;
        }
    }
}
