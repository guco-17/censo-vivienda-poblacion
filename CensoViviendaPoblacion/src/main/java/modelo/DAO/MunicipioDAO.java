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
    
    public ArrayList<Municipio> obtenerTodos() {
        ArrayList<Municipio> municipios = new ArrayList<>();
        String sql = "SELECT idMunicipio, descripcion, cve_mun FROM Municipio ORDER BY descripcion";
        
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Municipio m = new Municipio();
                m.setId(rs.getInt("idMunicipio"));
                m.setDescripcion(rs.getString("descripcion"));
                m.setCve_mun(rs.getString("cve_mun"));
                municipios.add(m);
            }
        } catch (SQLException e) {
            System.err.println("Error SQL: " + e.getMessage());
        }
        return municipios;
    }
    
    public boolean agregar(Municipio entidad) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public boolean actualizar(Municipio entidad) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public boolean eliminar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Municipio obtenerPorId(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
