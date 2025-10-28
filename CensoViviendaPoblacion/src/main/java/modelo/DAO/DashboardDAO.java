package modelo.DAO;

import java.sql.*;
import modelo.ConexionDB;

public class DashboardDAO {
    private Connection conn = ConexionDB.getInstance().getConnection();
    
    public DashboardDAO() {
        this.conn = ConexionDB.getInstance().getConnection(); 
    }
    
    //KPI POBLACIÓN TOTAL
    public int contarTotalHabitantes() {
        int total = 0;
        String sql = "SELECT COUNT(idHabitante) AS total FROM Habitante"; 
        
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            if (rs.next()) {
                total = rs.getInt("total");
            }
        } catch (SQLException e) {
            System.err.println("Error SQL al contar el total de habitantes: " + e.getMessage());
        }
        return total;
    }
    
    //KPI POBLACIÓN ACTIVA ECONÓMICAMENTE
    public int contarPoblacionEconomicamenteActiva() {
        int total = 0;
        String sql = "SELECT COUNT(idHabitante) AS total FROM Habitante_Actividad";
        
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            if (rs.next()) {
                total = rs.getInt("total");
            }
        } catch (SQLException e) {
            System.err.println("Error SQL al contar la PEA: " + e.getMessage());
        }
        return total;
    }
    
    //KPI VIVIENDAS CON SERVICIOS BÁSICOS.
    public int contarTotalViviendas() {
        int total = 0;
        String sql = "SELECT COUNT(idVivienda) AS total FROM Vivienda";
        
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            if (rs.next()) {
                total = rs.getInt("total");
            }
        } catch (SQLException e) {
            System.err.println("Error SQL al contar total de viviendas: " + e.getMessage());
        }
        return total;
    }
    
    public int contarViviendasConServiciosCompletos() {
        int total = 0;
        String sql = "SELECT COUNT(idVivienda) AS total FROM Vivienda " +
                     "WHERE tieneAgua = 'S' AND tieneLuz = 'S' AND tieneGas = 'S'";
        
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            if (rs.next()) {
                total = rs.getInt("total");
            }
        } catch (SQLException e) {
            System.err.println("Error SQL al contar viviendas con servicios completos: " + e.getMessage());
        }
        return total;
    }
}
