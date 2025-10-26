package modelo.DAO;

import java.security.*;
import modelo.ConexionDB;
import modelo.Usuario;
import java.sql.*;
import java.util.ArrayList;

public class UsuarioDAO{
    private Connection conn = ConexionDB.getInstance().getConnection();
            
    public UsuarioDAO() {
        this.conn = ConexionDB.getInstance().getConnection(); 
    }
    
    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(password.getBytes());
            
            // Convertir los bytes a formato hexadecimal
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
            
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al generar el hash: " + e.getMessage());
        }
    }
    
    public Usuario validarCredenciales(String nombreUsuario, String password){
        Usuario user = null;
        String passwordHash = hashPassword(password);
        if (passwordHash == null) {
            return null; 
        }
        ResultSet rs = null;
        String sql = "SELECT idUsuario, nombreUsuario, rol FROM Usuario WHERE nombreUsuario = ? AND passwordHash = ?";
        
        try(PreparedStatement ps = this.conn.prepareCall(sql)){
            ps.setString(1, nombreUsuario);
            ps.setString(2, passwordHash);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                user = new Usuario();
                user.setIdUsuario(rs.getInt("idUsuario"));
                user.setNombreUsuario(rs.getString("nombreUsuario"));
                user.setRol(rs.getString("rol"));
                user.setSesionIniciada(true); 
            }
        } catch(SQLException e){
            System.err.println("Error SQL al validar credenciales: " + e.getMessage());
        }
        return user;
    }
    
    public boolean agregar(Usuario usuario){
        String sql = "INSERT INTO Usuario (nombreUsuario, passwordHash, rol) VALUES (?, ?, ?)";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)){
            String hashedPasword = hashPassword(usuario.getPassword());
            
            ps.setString(1, usuario.getNombreUsuario());
            ps.setString(2, hashedPasword); 
            ps.setString(3, usuario.getRol());
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e){
            System.err.println("Error SQL: " + e.getMessage());
            return false;
        }
    }
    
    public boolean eliminar(String nombreUsuario){
        String sql = "DELETE FROM Usuario WHERE nombreUsuario = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nombreUsuario);
            
            int filasAfectadas = ps.executeUpdate();
            // Retorna true si se eliminó una fila o más.
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.err.println("Error SQL: " + e.getMessage());
            return false;
        }
    }
}
