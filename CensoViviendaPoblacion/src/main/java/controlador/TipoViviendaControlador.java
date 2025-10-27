package controlador;

import modelo.DAO.TipoViviendaDAO;
import modelo.TipoVivienda;
import java.util.ArrayList;
import java.sql.SQLException;

public class TipoViviendaControlador {
    private final TipoViviendaDAO tipoViviendaDAO;

    public TipoViviendaControlador() {
        this.tipoViviendaDAO = new TipoViviendaDAO();
    }

    // Validaciones y llamado a DAO para Registrar
    public boolean registrarTipoVivienda(TipoVivienda tv) throws Exception {
        if (tv.getDescripcion() == null || tv.getDescripcion().trim().isEmpty()) {
            throw new Exception("La descripción del Tipo de Vivienda es obligatoria.");
        }
        try {
            return tipoViviendaDAO.agregar(tv);
        } catch (SQLException e) {
            // Manejar error de UNIQUE (si la descripción ya existe)
            if (e.getMessage().contains("UNIQUE constraint")) {
                 throw new Exception("El Tipo de Vivienda '" + tv.getDescripcion() + "' ya existe.", e);
            }
            throw new Exception("Error al registrar Tipo de Vivienda: " + e.getMessage(), e);
        }
    }
    
    // Validaciones y llamado a DAO para Actualizar
    public boolean actualizarTipoVivienda(TipoVivienda tv) throws Exception {
        if (tv.getId()<= 0) {
            throw new Exception("Se requiere un ID de Tipo de Vivienda válido para actualizar.");
        }
        if (tv.getDescripcion() == null || tv.getDescripcion().trim().isEmpty()) {
            throw new Exception("La descripción del Tipo de Vivienda es obligatoria.");
        }
        try {
            return tipoViviendaDAO.actualizar(tv);
        } catch (SQLException e) {
            if (e.getMessage().contains("UNIQUE constraint")) {
                 throw new Exception("El Tipo de Vivienda '" + tv.getDescripcion() + "' ya existe.", e);
            }
            throw new Exception("Error al actualizar Tipo de Vivienda: " + e.getMessage(), e);
        }
    }
    
    // Llamado a DAO para Eliminar
    public boolean eliminarTipoVivienda(int idTipoVivienda) throws Exception {
        if (idTipoVivienda <= 0) {
            throw new Exception("Se requiere un ID válido para eliminar.");
        }
        try {
            return tipoViviendaDAO.eliminar(idTipoVivienda);
        } catch (SQLException e) {
            // Manejar error de clave foránea (si está siendo usado por Vivienda)
            if (e.getMessage().contains("REFERENCE constraint")) {
                 throw new Exception("No se puede eliminar el Tipo de Vivienda porque está siendo usado por una o más viviendas.", e);
            }
            throw new Exception("Error al eliminar Tipo de Vivienda: " + e.getMessage(), e);
        }
    }

    // Llamado a DAO para Obtener Todos
    public ArrayList<TipoVivienda> obtenerTodos() throws Exception {
        return tipoViviendaDAO.obtenerTodos();
    }
}