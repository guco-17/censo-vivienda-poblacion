package controlador;

import modelo.DAO.ViviendaDAO;
import modelo.Vivienda;
import java.util.ArrayList;

public class ViviendaControlador {
    private final ViviendaDAO viviendaDAO;

    public ViviendaControlador() {
        this.viviendaDAO = new ViviendaDAO();
    }
    
    public boolean registrarVivienda(Vivienda vivienda) throws Exception {
        if (vivienda.getCodigoVivienda() <= 0) {
            throw new Exception("El Código de Vivienda es obligatorio y debe ser positivo.");
        }
        
        if (vivienda.getCalle() == null || vivienda.getCalle().trim().isEmpty()) {
            throw new Exception("La Calle de la vivienda es obligatoria.");
        }
        
        if (vivienda.getCuartos() < 1) {
            throw new Exception("La vivienda debe tener al menos un cuarto.");
        }
        
        if (vivienda.getIdLocalidad() <= 0) {
            throw new Exception("Debe seleccionar una Localidad válida. ID: " + vivienda.getIdLocalidad());
        }
        
        if (vivienda.getIdTipoVivienda() <= 0) {
            throw new Exception("Debe seleccionar un Tipo de Vivienda válido. ID: " + vivienda.getIdTipoVivienda());
        }
        
        return viviendaDAO.agregar(vivienda);
    }
    public boolean actualizarVivienda(Vivienda vivienda) throws Exception {
        if (vivienda.getCodigoVivienda()<= 0) {
            throw new Exception("Se requiere el codigo de la vivienda para poder actualizarla.");
        }
        
        return viviendaDAO.actualizar(vivienda);
    }

    // B. Método de Eliminación
    public boolean eliminarVivienda(int idVivienda) throws Exception {
        if (idVivienda <= 0) {
            throw new Exception("Se requiere una ID de vivienda válida para eliminar.");
        }
        
        return viviendaDAO.eliminar(idVivienda);
    }
}
