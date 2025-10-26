package modelo.DAO;

import modelo.ConexionDB;
import modelo.Habitante;
import java.sql.*;
import java.util.ArrayList;

public class HabitanteDAO{
    private Connection conn = ConexionDB.getInstance().getConnection();
    
    public HabitanteDAO() {
        this.conn = ConexionDB.getInstance().getConnection(); 
    }
    
    public boolean agregar(Habitante habitante){
        String sql = "INSERT INTO Habitante (nombre, paterno, materno, fechaNacimiento, genero, estadoCivil, nivelEducacion) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try(PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1, habitante.getNombre());
            ps.setString(2, habitante.getPaterno());
            ps.setString(3, habitante.getMaterno());
            ps.setDate(4, new java.sql.Date(habitante.getFechaNacimiento().getTime())); 
            ps.setString(5, habitante.getGenero());
            ps.setString(6, habitante.getEstadoCivil());
            ps.setString(7, habitante.getNivelEducacion());
            
            int filasAfectadas = ps.executeUpdate();
            
            // Opcional: Obtener el ID generado (si lo necesitas)
            if (filasAfectadas > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        habitante.setIdHabitante(rs.getInt(1));
                    }
                }
            }
            return filasAfectadas > 0;
        } catch (SQLException e){
            System.err.println("Error SQL al agregar habitante: " + e.getMessage());
            return false;
        }
    }
    
    public boolean actualizar(Habitante habitante){
        String sql = "UPDATE Habitante SET nombre=?, paterno=?, materno=?, fechaNacimiento=?, genero=?, estadoCivil=?, nivelEducacion=? WHERE idHabitante=?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, habitante.getNombre());
            ps.setString(2, habitante.getPaterno());
            ps.setString(3, habitante.getMaterno());
            ps.setDate(4, new java.sql.Date(habitante.getFechaNacimiento().getTime()));
            ps.setString(5, habitante.getGenero());
            ps.setString(6, habitante.getEstadoCivil());
            ps.setString(7, habitante.getNivelEducacion());
            ps.setInt(8, habitante.getIdHabitante()); // Condición WHERE
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.err.println("Error SQL al agregar habitante: " + e.getMessage());
            return false;
        }
    }
    
    public boolean eliminar(int id){
        String sql = "DELETE FROM Habitante WHERE idHabitante = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.err.println("Error SQL al agregar habitante: " + e.getMessage());
            return false;
        }
    }
    
    public ArrayList<Habitante> obtenerTodos(){
        ArrayList<Habitante> habitantes = new ArrayList<>();
        String sql = "SELECT idHabitante, nombre, paterno, materno, fechaNacimiento, genero, estadoCivil, nivelEducacion FROM Habitante";
        
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Habitante h = new Habitante();
                h.setIdHabitante(rs.getInt("idHabitante"));
                h.setNombre(rs.getString("nombre"));
                h.setPaterno(rs.getString("paterno"));
                h.setMaterno(rs.getString("materno"));
                h.setFechaNacimiento(rs.getDate("fechaNacimiento")); // Mapear a Date
                h.setGenero(rs.getString("genero"));
                h.setEstadoCivil(rs.getString("estadoCivil"));
                h.setNivelEducacion(rs.getString("nivelEducacion"));
                habitantes.add(h);
            }
        } catch (SQLException e) {
            System.err.println("Error SQL al agregar habitante: " + e.getMessage());
        }
        return habitantes;
    }   
}
