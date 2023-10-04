package utilities;

import java.sql.DriverManager;


public class ManageDB extends CommonOps{
    public static void openConnection(String dbURL, String user, String pass){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(dbURL,user,pass);
            stmt = con.createStatement();
            System.out.println("Connected to DB");
        } catch (Exception e) {
            System.out.println("Error occured while connecting to DB, see details: " + e);
        }
    }

    public static void closeConnection(){
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("Error occured while closing DB, see details: " + e);
        }
    }
}
