package controlador;

import modelo.DAO.HabitanteDAO;
import modelo.Habitante; 
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class HabitanteControlador {
    private HabitanteDAO habitanteDAO;
    
    public HabitanteControlador() {
        this.habitanteDAO = new HabitanteDAO();
    }
    
    private long calcularEdad(Date fechaNacimiento){
        if (fechaNacimiento == null){
            return 0;
        }
        LocalDate fechaNac = fechaNacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return ChronoUnit.YEARS.between(fechaNac, LocalDate.now());
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
        
        return habitanteDAO.agregar(habitante);
    }
    
    public boolean actualizarHabitante(Habitante habitante) throws Exception {
        if (habitante.getIdHabitante() <= 0) {
            throw new Exception("No se ha seleccionado ningún habitante para actualizar. Se requiere un ID válido.");
        }
        
        if (habitante.getNombre().trim().isEmpty() || habitante.getPaterno().trim().isEmpty()) {
            throw new Exception("El Nombre y Apellido Paterno no pueden quedar vacíos.");
        }
        
        return habitanteDAO.actualizar(habitante);
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
}
