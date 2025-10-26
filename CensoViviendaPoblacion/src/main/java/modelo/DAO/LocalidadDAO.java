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
    
    public ArrayList<Localidad> obtenerPorMunicipio(int idMunicipio){
        ArrayList<Localidad> localidades = new ArrayList<>();
        // La tabla Localidad debe tener la columna idMunicipio.
        String sql = "SELECT idLocalidad, descripcion, cve_loc, idMunicipio FROM Localidad WHERE idMunicipio = ? ORDER BY descripcion";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idMunicipio);
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Localidad l = new Localidad();
                    l.setId(rs.getInt("idLocalidad"));
                    l.setDescripcion(rs.getString("descripcion"));
                    l.setCve_loc(rs.getString("cve_loc"));
                    l.setIdMunicipio(rs.getInt("idMunicipio"));
                    // En un modelo más avanzado, aquí podrías buscar y asignar el objeto Municipio.
                    localidades.add(l);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error SQL: " + e.getMessage());
        }
        return localidades;
    }
    
    public ArrayList<Localidad> obtenerTodos() throws Exception {
        ArrayList<Localidad> localidades = new ArrayList<>();
        String sql = "SELECT idLocalidad, descripcion, cve_loc, idMunicipio FROM Localidad ORDER BY descripcion";

        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Localidad l = new Localidad();
                l.setId(rs.getInt("idLocalidad")); 
                l.setDescripcion(rs.getString("descripcion"));
                l.setCve_loc(rs.getString("cve_loc"));
                l.setIdMunicipio(rs.getInt("idMunicipio")); 
                localidades.add(l);
            }
        } catch (SQLException e) {
            throw new Exception("Error al obtener la lista de localidades: " + e.getMessage(), e);
        }
        return localidades;
    }
    
    public boolean agregar(Localidad entidad) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public boolean actualizar(Localidad entidad) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public boolean eliminar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public Localidad obtenerPorId(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
