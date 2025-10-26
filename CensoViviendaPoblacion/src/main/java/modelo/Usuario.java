package modelo;

public class Usuario {
    //ATRIBUTOS DE LA ENTIDAD (CAMPOS EN LA BD)
    private int idUsuario;
    private String nombreUsuario;
    private String password;
    private String rol;
    //ATRIBUTOS DE LA LÓGICA DEL NEGOCIO
    private boolean sesionIniciada;

    //CONSTRUCTOR VACÍO
    public Usuario() {
    }
    
    //CONSTRUCTOR
    public Usuario(String nombreUsuario, String password){
        this.nombreUsuario = nombreUsuario;
        this.password = password;
    }
    
    //GETTERS Y SETTERS
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public boolean isSesionIniciada() {
        return sesionIniciada;
    }

    public void setSesionIniciada(boolean sesionIniciada) {
        this.sesionIniciada = sesionIniciada;
    }
    
    
}
