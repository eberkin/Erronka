package ticketbaiproiektua;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class mySQLkonexioa {
    
    public static Connection getConector(String servidor,String bd,String user,String pswd) {
        Connection conexion = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            String URL="jdbc:mysql://"+servidor+":8889/"+bd;
            conexion=DriverManager.getConnection(URL,user,pswd);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conexion;
    }

}