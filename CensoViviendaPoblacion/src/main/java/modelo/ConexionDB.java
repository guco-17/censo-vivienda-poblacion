package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private final String URL = "jdbc:sqlserver://localhost:1433;databaseName=censo_vivienda_poblacion;encrypt=false;trustServerCertificate=true";
    private final String USER = "SA";
    private final String PASSWORD = "Admin1234";
    
    private Connection connection;
       
    private ConexionDB() {
        try{
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexion a SQL Server establecida con exito.");
        } catch(SQLException e){
            System.err.println("Error al conectar a SQL Server. Revisa tus credenciales y el conector JDBC: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static ConexionDB getInstance() {
        return ConexionDBHolder.INSTANCE;
    }
    
    private static class ConexionDBHolder {
        private static final ConexionDB INSTANCE = new ConexionDB();
    }
    
    public Connection getConnection(){
        return connection;
    }
    
    public void closeConnection(){
        if (connection != null){
            try{
              connection.close();
            } catch(SQLException e){
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
