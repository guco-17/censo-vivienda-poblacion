package modelo.DAO;

import modelo.Catalogos.Catalogo;
import java.sql.*;
import java.util.ArrayList;

public abstract class CatalogoDAO<T extends Catalogo> implements InterfaceDAO<T>{
    protected Connection conn;
    protected String nombreTabla;
    protected Class<T> tipoClase;

    public CatalogoDAO(Connection conn, String nombreTabla, Class<T> tipoClase) {
        this.conn = conn;
        this.nombreTabla = nombreTabla;
        this.tipoClase = tipoClase;
    }
    
    @Override
    public ArrayList<T> obtenerTodos() throws Exception {
        ArrayList<T> lista = new ArrayList<>();
        String sql = "SELECT id, descripcion FROM " + nombreTabla + " ORDER BY descripcion";
        
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                T item = tipoClase.getDeclaredConstructor(int.class, String.class)
                                 .newInstance(rs.getInt("id"), rs.getString("descripcion"));
                lista.add(item);
            }
        } catch (SQLException e) {
            throw new Exception("Error al obtener todos los registros de la tabla " + nombreTabla + ": " + e.getMessage(), e);
        }
        return lista;
    }
    
    // --- Implementación Mínima (para no dejar métodos abstractos) ---
    // NOTA: Para un catálogo simple, no siempre necesitas implementar todos estos.
    @Override
    public T obtenerPorId(int id) throws Exception {
        throw new UnsupportedOperationException("Método no implementado para catálogos simples.");
    }
    @Override
    public boolean agregar(T entidad) throws Exception {
        throw new UnsupportedOperationException("Método no implementado para catálogos simples.");
    }
    @Override
    public boolean actualizar(T entidad) throws Exception {
        throw new UnsupportedOperationException("Método no implementado para catálogos simples.");
    }
    @Override
    public boolean eliminar(int id) throws Exception {
        throw new UnsupportedOperationException("Método no implementado para catálogos simples.");
    }
    
}
