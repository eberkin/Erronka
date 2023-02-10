package ticketbaiproiektua;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;



public class mySQLkonexioa {    

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private Connection conn;

   public mySQLkonexioa() {
      conn = null;
   }

   public Connection getConnection() {
      if (conn == null) {
         try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection("jdbc:mysql://192.168.:3306/salmentak", "root", "Pa$$w0rd");
            System.out.println("ONDO KONEKTATU DA");
         } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
             System.out.println("EZIN IZAN DA KONEKTATU");
         }
      }
      return conn;
   }

   public void closeConnection() {
      if (conn != null) {
         try {
            conn.close();
            conn = null;
            System.out.println("ONDO DESKONEKTATU DA");
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
   }

    Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}