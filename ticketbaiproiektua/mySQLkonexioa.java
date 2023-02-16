package ticketbaiproiektua;

import java.sql.*;
import java.util.ArrayList;

public class mySQLkonexioa {
   public static void obtener(ArrayList<Pegatina> salmentak){
      String sql;
      Statement sentencia;

      String url = "jdbc:mysql://10.23.29.61:3306/ticketbai";
      String user = "EBER";
      String password = "Admin123";

   try {
       Connection conn = DriverManager.getConnection(url, user, password);
       sentencia = conn.createStatement();
       for (Pegatina p : salmentak) {
         sql = "INSERT INTO TICKETBAI.TICKETA (izena, urtea_data, hilabetea_data, eguna_data, ordua_data, pisua, prezioa_kiloko, prezio_totala, idLANGILEA, idDENDA) " +
         "VALUES ('" + p.getIzena() + "', '" + p.getUrteaData() + "', '" + p.getHilabeteaData() + "', '" + p.getEgunaData() + "', '" + p.getOrduaData() + "', " + p.getPisua() + ", " + p.getPrezioa_kiloko() + ", " + p.getPrezio_totala() + ", " + p.getId_langilea() + ", "  + p.getId_denda() + ")";
         sentencia.executeUpdate(sql);
    }
       conn.close();
       }
        catch (SQLException e) {
       System.out.println("Error al conectarse a la base de datos: " + e.getMessage());
   }
}
}

