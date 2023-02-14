package ticketbaiproiektua;

import java.sql.*;
import java.util.ArrayList;

public class mySQLkonexioa {
   public static void obtener(ArrayList<Pegatina> salmentak){
      String sql;
      ResultSet rs;
      Statement sentencia;

      String url = "jdbc:mysql://10.23.29.61:3306/ticketbai";
      String user = "EBER";
      String password = "Admin123";

   try {
       Connection conn = DriverManager.getConnection(url, user, password);
       sentencia = conn.createStatement();
       sql = "SELECT idTICKETA, izena FROM ticketbai.ticketa";
       rs = sentencia.executeQuery(sql);
       while(rs.next()){
         int idTICKETA = rs.getInt("idTICKETA");
         String izena = rs.getString("izena");
         System.out.println(" ");
       }
       conn.close();
      
   } catch (SQLException e) {
       System.out.println("Error al conectarse a la base de datos: " + e.getMessage());
   }
}
}

