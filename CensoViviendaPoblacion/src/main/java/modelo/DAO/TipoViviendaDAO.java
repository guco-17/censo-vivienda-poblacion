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
    
}
