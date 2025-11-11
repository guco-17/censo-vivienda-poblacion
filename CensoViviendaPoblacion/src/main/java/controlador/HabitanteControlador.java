package controlador;

import modelo.DAO.HabitanteDAO;
import modelo.DAO.ActividadHabitanteDAO;
import modelo.Habitante; 
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import modelo.ActividadEconomica;

public class HabitanteControlador {
    private HabitanteDAO habitanteDAO;
    private ActividadHabitanteDAO haDAO;
    
    public HabitanteControlador() {
        this.habitanteDAO = new HabitanteDAO();
        this.haDAO = new ActividadHabitanteDAO();
    }
    
    private long calcularEdad(Date fechaNacimiento){
        if (fechaNacimiento == null){
            return 0;
        }
        LocalDate fechaNac = fechaNacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return ChronoUnit.YEARS.between(fechaNac, LocalDate.now());
    }
    
    private boolean guardarActividades(int idHabitante, ArrayList<ActividadEconomica> actividades) throws Exception {
        haDAO.eliminarRelaciones(idHabitante); 
        
        for (ActividadEconomica actividad : actividades) {
            if (!haDAO.agregarRelacion(idHabitante, actividad.getId())) {
                System.err.println("Fallo al guardar relación con Actividad ID: " + actividad.getId());
                return false;
            }
        }
        return true;
    }
    
    public boolean registrarHabitante(Habitante habitante) throws Exception{
        if (habitante.getNombre().trim().isEmpty() || habitante.getPaterno().trim().isEmpty() || habitante.getMaterno().trim().isEmpty()) {
            throw new Exception("El Nombre y Apellido Paterno son obligatorios.");
        }
        
        if (habitante.getFechaNacimiento() == null) {
            throw new Exception("La Fecha de Nacimiento es obligatoria.");
        }
        
        long edad = calcularEdad(habitante.getFechaNacimiento());
        if (edad < 0 || edad > 120) {
            throw new Exception("La fecha de nacimiento no es válida o la edad está fuera del rango lógico.");
        }
        
        if (habitanteDAO.agregar(habitante)) { 
            return guardarActividades(habitante.getIdHabitante(), habitante.getActividadesEconomicas());
        }
        
        return false;
    }
    
    public boolean actualizarHabitante(Habitante habitante) throws Exception {
        if (habitante.getCodigoHabitante() <= 0) {
            throw new Exception("No se ha seleccionado ningún habitante para actualizar. Se requiere un ID válido.");
        }
        
        if (habitante.getNombre().trim().isEmpty() || habitante.getPaterno().trim().isEmpty()) {
            throw new Exception("El Nombre y Apellido Paterno no pueden quedar vacíos.");
        }
        
        if (habitanteDAO.actualizar(habitante)) {
            return guardarActividades(habitante.getIdHabitante(), habitante.getActividadesEconomicas());
        }
        
        return false;
    }
    
    public boolean eliminarHabitante(int idHabitante) throws Exception {
        if (idHabitante <= 0) {
            throw new Exception("Se requiere un ID de Habitante válido para la eliminación.");
        }
        
        return habitanteDAO.eliminar(idHabitante);
    }
    
    public ArrayList<Habitante> obtenerTodosLosHabitantes(){
        return habitanteDAO.obtenerTodos(); 
    }
    
    public ArrayList<Habitante> obtenerTodosLosHabitantesConRelaciones() throws Exception {
        return habitanteDAO.obtenerTodosConRelaciones();
    }
}
