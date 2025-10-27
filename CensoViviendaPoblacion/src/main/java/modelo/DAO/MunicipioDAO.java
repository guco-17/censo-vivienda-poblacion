package modelo.DAO;

import modelo.ConexionDB;
import modelo.Municipio;
import java.sql.*;
import java.util.ArrayList;

public class MunicipioDAO {
    private Connection conn = ConexionDB.getInstance().getConnection();

    public MunicipioDAO() {
        this.conn = ConexionDB.getInstance().getConnection();
    }
    
    private Municipio mapearMunicipio(ResultSet rs) throws SQLException {
        Municipio m = new Municipio();
        m.setId(rs.getInt("idMunicipio"));
        m.setDescripcion(rs.getString("descripcion"));
        m.setCve_mun(rs.getString("cve_mun"));
        return m;
    }
    
    public ArrayList<Municipio> obtenerTodos() {
        ArrayList<Municipio> municipios = new ArrayList<>();
        String sql = "SELECT idMunicipio, descripcion, cve_mun FROM Municipio ORDER BY descripcion";
        
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                municipios.add(mapearMunicipio(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error SQL: " + e.getMessage());
        }
        return municipios;
    }
    
    public boolean agregar(Municipio entidad) throws Exception {
        String sql = "INSERT INTO Municipio (cve_mun, descripcion) VALUES (?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, entidad.getCve_mun());
            ps.setString(2, entidad.getDescripcion());
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.err.println("Error SQL al agregar Municipio: " + e.getMessage());
            throw e;
        }
    }
    
    public boolean actualizar(Municipio entidad) throws Exception {
        String sql = "UPDATE Municipio SET cve_mun = ?, descripcion = ? WHERE idMunicipio = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, entidad.getCve_mun());
            ps.setString(2, entidad.getDescripcion());
            ps.setInt(3, entidad.getId());
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.err.println("Error SQL al actualizar Municipio: " + e.getMessage());
            throw e;
        }
    }
    
    public boolean eliminar(int id) throws Exception {
        String sql = "DELETE FROM Municipio WHERE idMunicipio = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.err.println("Error SQL al eliminar Municipio: " + e.getMessage());
            throw e;
        }
    }

    public Municipio obtenerPorId(int id) throws Exception {
        Municipio municipio = null;
        String sql = "SELECT idMunicipio, descripcion, cve_mun FROM Municipio WHERE idMunicipio = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    municipio = mapearMunicipio(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error SQL al obtener Municipio por ID: " + e.getMessage());
            throw e;
        }
        return municipio;
    }
    
}
