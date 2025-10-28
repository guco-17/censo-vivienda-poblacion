package modelo.DAO;

import java.sql.*;
import java.util.*;
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
    
    public Map<String, Integer> contarHabitantesPorGenero() {
        Map<String, Integer> resultados = new HashMap<>();
        String sql = "SELECT genero, COUNT(idHabitante) AS conteo FROM Habitante GROUP BY genero";

        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                resultados.put(rs.getString("genero"), rs.getInt("conteo"));
            }
        } catch (SQLException e) {
            System.err.println("Error SQL al contar habitantes por género: " + e.getMessage());
        }
        return resultados;
    }
}
