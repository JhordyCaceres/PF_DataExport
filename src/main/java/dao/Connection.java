package dao;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {

    private java.sql.Connection conexion = null;

    public java.sql.Connection conectar() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conexion = DriverManager.getConnection("jdbc:sqlserver://35.225.197.180:1433;DatabaseName=hw", "sqlserver", "sqlserver");
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
            System.out.println("dao.Connection.conectar()");
        }
        return conexion;
    }

    public void desconectar() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.out.println("dao.Connection.desconectar()");
        }
    }
}
