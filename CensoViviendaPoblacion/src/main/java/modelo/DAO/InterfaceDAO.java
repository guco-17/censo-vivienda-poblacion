package modelo.DAO;

import java.util.ArrayList;

public interface InterfaceDAO<T> {
    public boolean agregar(T entidad) throws Exception;
    
    public T obtenerPorId(int id) throws Exception;
    
    public ArrayList<T> obtenerTodos() throws Exception;
    
    public boolean actualizar(T entidad) throws Exception;
    
    public boolean eliminar(int id) throws Exception;
}
