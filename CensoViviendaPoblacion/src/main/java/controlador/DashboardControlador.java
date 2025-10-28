package controlador;

import modelo.DAO.DashboardDAO;
import java.text.DecimalFormat;
import java.util.*;

public class DashboardControlador {
    private final DashboardDAO dashboardDAO;
    private final DecimalFormat df = new DecimalFormat("#.00");
    
    public DashboardControlador() {
        this.dashboardDAO = new DashboardDAO();
    }
    
    public int obtenerPoblacionTotal() {
        return dashboardDAO.contarTotalHabitantes();
    }
    
    public int obtenerPoblacionActivaEconomica() {
        return dashboardDAO.contarPoblacionEconomicamenteActiva();
    }
    
    public int obtenerViviendas() {
        return dashboardDAO.contarTotalViviendas();
    }
    
    public Map<String, Integer> obtenerDistribucionPorGenero() {
        return dashboardDAO.contarHabitantesPorGenero();
    }
}
