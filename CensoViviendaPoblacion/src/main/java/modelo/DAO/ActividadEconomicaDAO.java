package modelo.DAO;

import java.sql.*;
import java.util.ArrayList;
import modelo.ActividadEconomica;
import modelo.ConexionDB;

public class ActividadEconomicaDAO {
    private Connection conn = ConexionDB.getInstance().getConnection();
    
    public ActividadEconomicaDAO() {
        this.conn = ConexionDB.getInstance().getConnection(); 
    }
    
    private ActividadEconomica mapearActividadEconomica(ResultSet rs) throws SQLException{
        ActividadEconomica a = new ActividadEconomica();
        a.setId(rs.getInt("idActividadEconomica"));
        a.setDescripcion(rs.getString("descripcion"));
        
        return a;
    }
    
    public ActividadEconomica obtenerPorId(int id){
        ActividadEconomica actividad = null;
        String sql = "SELECT * FROM ActividadEconomica WHERE idActividadEconomica = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    actividad = mapearActividadEconomica(rs);
                }
            }

        } catch(SQLException e){
            System.err.print("Error al obtener actividad economica: " + e);
        }
        return actividad;
    }
    
    public ArrayList<ActividadEconomica> obtenerTodos(){
        ArrayList<ActividadEconomica> lista = new  ArrayList<>();
        String sql = "SELECT * FROM ActividadEconomica";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                lista.add(mapearActividadEconomica(rs));
            }

        } catch(SQLException e){
            System.err.print("Error al obtener actividad economica: " + e);
        }
        return lista;
    }
    
}
