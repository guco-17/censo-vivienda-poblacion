package controlador;

import modelo.DAO.DashboardDAO;
import java.text.DecimalFormat;
import java.util.*;
import modelo.DAO.MunicipioDAO;
import modelo.Municipio;

public class DashboardControlador {
    private final DashboardDAO dashboardDAO;
    private final MunicipioDAO municipioDAO;
    private final DecimalFormat df = new DecimalFormat("#.00");
    
    public DashboardControlador() {
        this.dashboardDAO = new DashboardDAO();
        this.municipioDAO = new MunicipioDAO();
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
    
    public Map<String, Map<String, Integer>> obtenerNivelEducativoPorMunicipio(String nombreMunicipio) {
        return dashboardDAO.obtenerNivelEducativoPorMunicipio(nombreMunicipio);
    }
    
    public Map<String, Integer> obtenerTop5ActividadesEconomicas() {
        return dashboardDAO.obtenerTop5ActividadesEconomicas();
    }
    
    public List<Map<String, Object>> obtenerTablaHabitantesViviendas(String nombreMunicipio) {
        return dashboardDAO.obtenerHabitantesPorVivienda(nombreMunicipio);
    }
    
    public ArrayList<Municipio> obtenerNombresMunicipios() {
        return municipioDAO.obtenerTodos();
    }
    
    public double promedioHabitantesPorVivienda(String nombreMunicipio) {
        return dashboardDAO.promedioHabitantesPorVivienda(nombreMunicipio);
    }
    
    public Map<String, Integer> obtenerHabitantesPorTipoVivienda(String nombreMunicipio) {
        return dashboardDAO.obtenerHabitantesPorTipoVivienda(nombreMunicipio);
    }
}
