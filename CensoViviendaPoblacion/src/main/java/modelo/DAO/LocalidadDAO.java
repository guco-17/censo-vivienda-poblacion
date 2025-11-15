package modelo.DAO;

import modelo.ConexionDB;
import modelo.Localidad;
import java.sql.*;
import java.util.ArrayList;

public class LocalidadDAO {
    private Connection conn = ConexionDB.getInstance().getConnection(); 

    public LocalidadDAO() {
        this.conn = ConexionDB.getInstance().getConnection();
    }
    
    private Localidad mapearLocalidad(ResultSet rs) throws SQLException {
        Localidad l = new Localidad();
        l.setId(rs.getInt("idLocalidad"));
        l.setDescripcion(rs.getString("descripcion"));
        l.setCve_loc(rs.getString("cve_loc"));
        l.setIdMunicipio(rs.getInt("idMunicipio"));
        return l;
    }
    
    public ArrayList<Localidad> obtenerPorMunicipio(int idMunicipio){
        ArrayList<Localidad> localidades = new ArrayList<>();
        String sql = "SELECT idLocalidad, descripcion, cve_loc, idMunicipio FROM Localidad WHERE idMunicipio = ? ORDER BY descripcion";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idMunicipio);
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    localidades.add(mapearLocalidad(rs));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error SQL: " + e.getMessage());
        }
        return localidades;
    }
    
    public Localidad obtenerPorId(int id) throws Exception {
        Localidad localidad = null;
        String sql = "SELECT idLocalidad, descripcion, cve_loc, idMunicipio FROM Localidad WHERE idLocalidad = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    localidad = mapearLocalidad(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error SQL al obtener Localidad por ID: " + e.getMessage());
            throw new Exception("Error al obtener Localidad por ID: " + e.getMessage(), e);
        }
        return localidad;
    }
    
    public ArrayList<Localidad> obtenerTodos() throws Exception {
        ArrayList<Localidad> localidades = new ArrayList<>();
        String sql = "SELECT idLocalidad, descripcion, cve_loc, idMunicipio FROM Localidad ORDER BY idMunicipio";

        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                localidades.add(mapearLocalidad(rs));
            }
        } catch (SQLException e) {
            throw new Exception("Error al obtener la lista de localidades: " + e.getMessage(), e);
        }
        return localidades;
    }
    
    public boolean agregar(Localidad entidad) throws Exception {
        String sql = "INSERT INTO Localidad (cve_loc, descripcion, idMunicipio) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, entidad.getCve_loc());
            ps.setString(2, entidad.getDescripcion());
            ps.setInt(3, entidad.getIdMunicipio());
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.err.println("Error SQL al agregar Localidad: " + e.getMessage());
            throw new Exception("Error al agregar la Localidad: " + e.getMessage(), e);
        }
    }
    
    public boolean actualizar(Localidad entidad) throws Exception {
        String sql = "UPDATE Localidad SET cve_loc = ?, descripcion = ?, idMunicipio = ? WHERE idLocalidad = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, entidad.getCve_loc());
            ps.setString(2, entidad.getDescripcion());
            ps.setInt(3, entidad.getIdMunicipio());
            ps.setInt(4, entidad.getId());
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.err.println("Error SQL al actualizar Localidad: " + e.getMessage());
            throw new Exception("Error al actualizar la Localidad: " + e.getMessage(), e);
        }
    }
    
    public boolean eliminar(int id) throws Exception {
        String sql = "DELETE FROM Localidad WHERE idLocalidad = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.err.println("Error SQL al eliminar Localidad: " + e.getMessage());
            throw new Exception("Error al eliminar la Localidad: " + e.getMessage(), e);
        }
    }
}
