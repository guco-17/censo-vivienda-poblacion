package modelo.DAO;

import modelo.ConexionDB;
import java.sql.*;
import java.util.ArrayList;
import modelo.ActividadEconomica;

public class ActividadHabitanteDAO {
    private Connection conn;

    public ActividadHabitanteDAO() {
        conn = ConexionDB.getInstance().getConnection();
    }
    
    private ActividadEconomica mapearActividadEconomica(ResultSet rs) throws SQLException {
        ActividadEconomica a = new ActividadEconomica();
        a.setId(rs.getInt("idActividadEconomica"));
        a.setDescripcion(rs.getString("descripcion"));
        return a;
    }
    
    public boolean agregarRelacion(int idHabitante, int idActividadEconomica) throws SQLException {
        String sql = "INSERT INTO Habitante_Actividad (idHabitante, idActividadEconomica) VALUES (?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idHabitante);
            ps.setInt(2, idActividadEconomica);

            return ps.executeUpdate() > 0;
        }
    }
    
    public boolean eliminarRelaciones(int idHabitante) throws SQLException {
        String sql = "DELETE FROM Habitante_Actividad WHERE idHabitante = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idHabitante);
            return ps.executeUpdate() >= 0;
        }
    }
    
    public ArrayList<ActividadEconomica> obtenerActividadesPorHabitante(int idHabitante) throws SQLException, Exception {
        ArrayList<ActividadEconomica> actividades = new ArrayList<>();
        String sql = "SELECT t2.* FROM Habitante_Actividad t1 " +
                     "JOIN ActividadEconomica t2 ON t1.idActividadEconomica = t2.idActividadEconomica " +
                     "WHERE t1.idHabitante = ?";
        
        ActividadEconomicaDAO actividadDAO = new ActividadEconomicaDAO();
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idHabitante);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ActividadEconomica a = mapearActividadEconomica(rs);
                    actividades.add(a);
                }
            }
        }
        catch (SQLException e) {
            throw new Exception("Error al obtener actividades del habitante (ID: " + idHabitante + "): " + e.getMessage(), e);
        }
        return actividades;
    }
    
}
