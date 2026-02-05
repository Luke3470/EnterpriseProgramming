package uk.ac.mmu.enterpriseprogramming.model;

import uk.ac.mmu.enterpriseprogramming.DB.DB;
import uk.ac.mmu.enterpriseprogramming.DB.MySQLDB;
import uk.ac.mmu.enterpriseprogramming.model.data.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class UserModel {

    public static List<User> getUsers(){
        List<User> userList = new ArrayList<User>();

        String query = "SELECT * FROM contacts";
        DB db = new MySQLDB();
        try(Connection conn = db.createCon()){
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                User user = new User(
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getInt("id")
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
