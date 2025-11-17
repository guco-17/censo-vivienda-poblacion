package controlador;

import modelo.DAO.DashboardDAO;
import java.text.DecimalFormat;
import java.util.*;
import modelo.DAO.MunicipioDAO;
import modelo.DAO.LocalidadDAO;
import modelo.Localidad;
import modelo.Municipio;

public class DashboardControlador {
    private final DashboardDAO dashboardDAO;
    private final MunicipioDAO municipioDAO;
    private final LocalidadDAO localidadDAO;
    private final DecimalFormat df = new DecimalFormat("#.00");
    
    public DashboardControlador() {
        this.dashboardDAO = new DashboardDAO();
        this.municipioDAO = new MunicipioDAO();
        this.localidadDAO = new LocalidadDAO();
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
    
    public Map<String, Map<String, Integer>> obtenerNivelEducativoPorMunicipio(String nombreMunicipio, String nombreLocalidad) {
        return dashboardDAO.obtenerNivelEducativoPorMunicipio(nombreMunicipio, nombreLocalidad);
    }
    
    public Map<String, Integer> obtenerTop5ActividadesEconomicas() {
        return dashboardDAO.obtenerTop5ActividadesEconomicas();
    }
    
    public List<Map<String, Object>> obtenerTablaHabitantesViviendas(String nombreMunicipio, String nombreLocalidad, Integer codigoVivienda) {
        return dashboardDAO.obtenerHabitantesPorVivienda(nombreMunicipio, nombreLocalidad, codigoVivienda);
    }
    
    public ArrayList<Municipio> obtenerNombresMunicipios() {
        return municipioDAO.obtenerTodos();
    }
    
    public ArrayList<Localidad> obtenerNombresLocalidades() throws Exception {
        return localidadDAO.obtenerTodos();
    }
    
    public double promedioHabitantesPorVivienda(String nombreMunicipio, String nombreLocalidad) {
        return dashboardDAO.promedioHabitantesPorVivienda(nombreMunicipio, nombreLocalidad);
    }
    
    public Map<String, Integer> obtenerHabitantesPorTipoVivienda(String nombreMunicipio, String nombreLocalidad) {
        return dashboardDAO.obtenerHabitantesPorTipoVivienda(nombreMunicipio, nombreLocalidad);
    }
    
    public Map<String, Integer> obtenerserviciosBasicosMunicipio (String nombreMunicipio, String nombreLocalidad) {
        return dashboardDAO.serviciosBasicosMunicipio(nombreMunicipio, nombreLocalidad);
    }
    
    public double obtenerPorcentajeViviendasConServiciosCompletos(String nombreMunicipio, String nombreLocalidad) {
        return dashboardDAO.porcentajeViviendasConServiciosCompletos(nombreMunicipio, nombreLocalidad);
    }
    
    public int obtenerPoblacionMunicipio(String nombreMunicipio) {
        return dashboardDAO.contarTotalHabitantesMunicipio(nombreMunicipio);
    }
    
    public Map<String, Integer> obtenerTop5MunicipiosMasPoblados() {
        return dashboardDAO.top5MunicipiosMasPoblados();
    }
    
    public Map<String, Double> obtenerDistribucionPorEdad() {
        return dashboardDAO.distribucionPorEdad();
    }
}
