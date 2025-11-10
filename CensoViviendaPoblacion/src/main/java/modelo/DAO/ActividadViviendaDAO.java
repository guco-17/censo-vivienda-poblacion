package modelo.DAO;

import modelo.ConexionDB;
import java.sql.*;
import java.util.ArrayList;
import modelo.ActividadEconomica;

public class ActividadViviendaDAO {
    private Connection conn;

    public ActividadViviendaDAO() {
        conn = ConexionDB.getInstance().getConnection();
    }
    
    private ActividadEconomica mapearActividadEconomica(ResultSet rs) throws SQLException {
        ActividadEconomica a = new ActividadEconomica();
        a.setId(rs.getInt("idActividadEconomica"));
        a.setDescripcion(rs.getString("descripcion"));
        return a;
    }
    
    public boolean agregarRelacion(int idVivienda, int idActividadEconomica) throws SQLException {
        String sql = "INSERT INTO Vivienda_Actividad (idVivienda, idActividadEconomica) VALUES (?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idVivienda);
            ps.setInt(2, idActividadEconomica);

            return ps.executeUpdate() > 0;
        }
    }
    
    public boolean eliminarRelaciones(int idVivienda) throws SQLException {
        String sql = "DELETE FROM Vivienda_Actividad WHERE idVivienda = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idVivienda);
            return ps.executeUpdate() >= 0;
        }
    }
    
    public ArrayList<ActividadEconomica> obtenerActividadesPorVivienda(int idVivienda) throws SQLException, Exception {
        ArrayList<ActividadEconomica> actividades = new ArrayList<>();
        String sql = "SELECT t2.* FROM Vivienda_Actividad t1 " +
                     "JOIN ActividadEconomica t2 ON t1.idActividadEconomica = t2.idActividadEconomica " +
                     "WHERE t1.idVivienda = ?";
                
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idVivienda);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ActividadEconomica a = mapearActividadEconomica(rs);
                    actividades.add(a);
                }
            }
        }
        catch (SQLException e) {
            throw new Exception("Error al obtener actividades del habitante (ID: " + idVivienda + "): " + e.getMessage(), e);
        }
        return actividades;
    }
    
}
