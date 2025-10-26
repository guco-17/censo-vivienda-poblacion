package controlador;

import modelo.DAO.UsuarioDAO;
import modelo.Usuario;

public class UsuarioControlador {
    private final UsuarioDAO usuarioDAO;
    
    public UsuarioControlador(){
        this.usuarioDAO = new UsuarioDAO();
    }
    
    public Usuario validarLogin(String nombreUsuario, String password) {
        return usuarioDAO.validarCredenciales(nombreUsuario, password);
    }
    
    public boolean crearUsuario(Usuario usuario){
        return usuarioDAO.agregar(usuario);
    }
    
    public boolean eliminarUsuario(Usuario usuario){
        return usuarioDAO.eliminar(usuario.getNombreUsuario());
    }
}
