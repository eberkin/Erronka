package ticketbaiproiektua;

import java.sql.*;

public class mySQLkonexioa {
private static Connection cnx = null;
public static Connection obtener() throws SQLException,  ClassNotFoundException {
  if (cnx == null) {
     try {
        Class.forName("com.mysql.jdbc.Driver");
        cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/ticketbai", "root", "Pa$$wOrd");
     } catch (SQLException ex) {
        throw new SQLException(ex);
     } catch (ClassNotFoundException ex) {
        throw new ClassCastException(ex.getMessage());
     }
  }
  return cnx;
  }

public static void cerrar() throws SQLException {
  if (cnx != null) {
     cnx.close();
  }
  }
}
