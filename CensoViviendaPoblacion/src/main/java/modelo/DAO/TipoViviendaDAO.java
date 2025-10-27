package modelo.DAO;

import modelo.ConexionDB;
import modelo.TipoVivienda;
import java.sql.*;
import java.util.ArrayList;

public class TipoViviendaDAO {
    private Connection conn;
    
    public TipoViviendaDAO() {
        this.conn = ConexionDB.getInstance().getConnection(); 
    }
    
    public ArrayList<TipoVivienda> obtenerTodos(){
        ArrayList<TipoVivienda> tipos = new ArrayList<>();
        String sql = "SELECT idTipoVivienda, descripcion FROM TipoVivienda ORDER BY descripcion";
        
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                TipoVivienda tv = new TipoVivienda();
                tv.setId(rs.getInt("idTipoVivienda"));               
                tv.setDescripcion(rs.getString("descripcion")); 
                tipos.add(tv);
            }
        } catch (SQLException e) {
            System.err.print("Error al obtener la lista de tipos de vivienda: " + e.getMessage());
        }
        return tipos;
    }
    
    public TipoVivienda mapearTipoVivienda(ResultSet rs) throws SQLException {
        TipoVivienda tv = new TipoVivienda();
        tv.setId(rs.getInt("idTipoVivienda"));
        tv.setDescripcion(rs.getString("descripcion"));
        return tv;
    }
       
    public boolean agregar(TipoVivienda tipoVivienda) throws SQLException {
        String sql = "INSERT INTO TipoVivienda (descripcion) VALUES (?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, tipoVivienda.getDescripcion());
            return ps.executeUpdate() > 0;
        }
    }
    
    public boolean actualizar(TipoVivienda tipoVivienda) throws SQLException {
        String sql = "UPDATE TipoVivienda SET descripcion = ? WHERE idTipoVivienda = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, tipoVivienda.getDescripcion());
            ps.setInt(2, tipoVivienda.getId());
            return ps.executeUpdate() > 0;
        }
    }
    
    public boolean eliminar(int idTipoVivienda) throws SQLException {
        String sql = "DELETE FROM TipoVivienda WHERE idTipoVivienda = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idTipoVivienda);
            return ps.executeUpdate() > 0;
        }
    }
    
}
